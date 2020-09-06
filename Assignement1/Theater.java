package Assignement1;

import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Theater {
    private Vector<User> users = new Vector<User>();
    private Vector<Movie> movies = new Vector<Movie>();
    private int totalticket;
    private Program statement = Program.RESERVATION;
    private User onlineUser;

    public Theater(){
        this.totalticket = 0;
    }

    void setStatement(Program state){
        statement = state;
    }

    public void Menu(){
        try {
            int menu = PrintMenu();
            if (menu == 1) {
                if (Login()) {
                    setStatement(Program.USER);
                }
            } else if (menu == 2) {
                SignUp();
            } else if (menu == 3) {
                setStatement((Program.END));
            } else {
                throw new InvalidMenuException();
            }
        }
        catch(InvalidMenuException e){
            System.out.println(e.getMessage());
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input");
        }
    }

    public void UserMenu()throws IOException{
        try {
            int menu = PrintUserProgram();
            if (menu == 1) {
                setStatement(Program.MOVIELIST);
            } else if (menu == 2) {
                CheckReservation(onlineUser);
            } else if (menu == 3){
                if(onlineUser.IsManager() == 1){
                    setStatement(Program.MANAGER);
                }
                else throw new InvalidMenuException();
            }
            else if (menu == 4) {
                setStatement(Program.RESERVATION);
            } else {
                throw new InvalidMenuException();
            }
        }
        catch(InvalidMenuException e){
            System.out.println(e.getMessage());
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input");
        }
    }

    public void ReserveMenu(){
        try {
            int menu = PrintMovieList();
            if (menu == 1) {
                ReservationMovie(SelectMovie(), onlineUser);
                setStatement(Program.USER);
            } else if (menu == 2) {
                setStatement(Program.USER);
            } else {
                throw new InvalidMenuException();
            }
        }
        catch(InvalidMenuException e){
            System.out.println(e.getMessage());
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input");
        }
    }

    public void TheaterMenu(){
        try{
            int menu = PrintMangerMenu();
            if (menu == 1){
                PrintTheaterInfo();
            }
            else if (menu == 2){
                PrintUserInfo();
            }
            else if (menu == 3){
                setStatement(Program.USER);
            }
            else{
                throw new InvalidMenuException();
            }
        }
        catch(InvalidMenuException e){
            System.out.println(e.getMessage());
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input");
        }
    }

    private int PrintMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("******영화 예매 프로그램******");
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 종료");
        System.out.print("메뉴를 선택해주세요 : ");
        return Integer.parseInt(scan.nextLine());
    }

    private boolean Login(){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("******로그인******");
            System.out.print("ID : ");
            String id = scan.nextLine();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getID().equals(id)) {
                    System.out.print("PW : ");
                    String pw = scan.nextLine();
                    if (users.get(i).getPW().equals(pw)) {
                        onlineUser = users.get(i);
                        return true;
                    }
                    throw new InvalidLoginException();
                }
            }
            throw new InvalidLoginException();
        }
        catch(InvalidLoginException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void SignUp(){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("******회원가입******");
            System.out.print("ID : ");
            String id = scan.nextLine();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getID().equals(id)) {
                    throw new DuplicatedIdException();
                }
            }
            System.out.print("Password : ");
            String pw = scan.nextLine();
            System.out.println("Are you manager? : ");
            String isadmin = scan.nextLine();
            users.addElement(new User(id, pw, Integer.parseInt(isadmin)));
            System.out.println("Success");
        }
        catch(DuplicatedIdException e){
            System.out.println(e.getMessage());
        }
    }

    private int PrintUserProgram(){
        Scanner scan = new Scanner(System.in);
        System.out.println("******유저프로그램******");
        System.out.println("1. 영화목록");
        System.out.println("2. 예매확인");
        System.out.println("3. 영화관 관리");
        System.out.println("4. 종료");
        System.out.print("메뉴를 선택해주세요 : ");
        return Integer.parseInt(scan.nextLine());
    }

    private int PrintMovieList(){
        Scanner scan = new Scanner(System.in);
        System.out.println("******영화목록******");
        for(int i = 0; i < movies.size(); i++){
            System.out.println(movies.get(i).toString());
        }
        System.out.println("1. 예매");
        System.out.println("2. 종료");
        System.out.print("메뉴를 선택해주세요: ");
        return Integer.parseInt(scan.nextLine());
    }

    private Movie SelectMovie(){
        Scanner scan = new Scanner(System.in);
        System.out.println("******영화목록******");
        for(int i = 0; i < movies.size(); i++){
            System.out.println(movies.get(i).getNO() +". " + movies.get(i).toString());
        }
        System.out.print("예매할 영화를 선택해주세요: ");
        return movies.get(Integer.parseInt(scan.nextLine()) - 1);
    }

    private void ReservationMovie(Movie movie, Member member){
        try {
            Scanner scan = new Scanner(System.in);
            if(member.IsManager() == 1){
                System.out.printf(movie.getName() + " 영화의 좌석 예매 점유율: %.2f%%\n", (float)movie.getTicketnum()/36 * 100);
                System.out.printf(movie.getName() + " 영화의 총 매출액: %d\n", movie.getTicketnum() * 10000);
            }
            System.out.println("******좌 석******");
            movie.PrintSeat();
            System.out.println("*****************");
            System.out.print("좌석을 선택해주세요(ex A1) : ");
            String seat = scan.nextLine();
            while(movie.SeatToNum(seat) == -1) {
                System.out.print("좌석을 선택해주세요(ex A1) : ");
                seat = scan.nextLine();
            }
            int tmpseat = movie.SeatToNum(seat);
            if (!(movie.getSeat(tmpseat))) {
                movie.setSeat(seat, true);
                member.addTicket(new Ticket(movie, seat, totalticket));
                totalticket += 1;
                movie.plusTicketnum();
                System.out.println("예약완료");
            } else {
                throw new DuplicatedReservationException();
            }
        }
        catch(DuplicatedReservationException e){
            System.out.println(e. getMessage());
        }
    }

    private void CheckReservation(User user){
        System.out.println("******예매 목록******");
        user.printTicket();
        System.out.println("Press enter to go back to User program");
    }

    private int PrintMangerMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("********영화관 관리********");
        System.out.println("1.영화관 정보");
        System.out.println("2.유저 정보");
        System.out.println("3.종료");
        System.out.printf("메뉴를 선택해주세요 : ");
        int menu = Integer.parseInt(scan.nextLine());
        System.out.println();
        return menu;
    }

    private void PrintTheaterInfo(){
        System.out.printf("점유된 전체 좌석 수: %d\n", totalticket);
        System.out.printf("전체 좌석 예매 점유율: %.2f%%\n", (float)totalticket/(movies.size() * 36) * 100);
        System.out.printf("영화관 총 매출액: %d\n", totalticket * 10000);
        System.out.println();
        System.out.println("예매율 현황");
        System.out.println("---------------------------------");
        Collections.sort(movies, new MovieReserveComparator());
        System.out.println("1위: " + movies.get(0) + "(좌석수 :" + movies.get(0).getTicketnum() +")");
        System.out.println("2위: " + movies.get(1) + "(좌석수 :" + movies.get(1).getTicketnum() +")") ;
        System.out.println("3위: " + movies.get(2) + "(좌석수 :" + movies.get(2).getTicketnum() +")");
        System.out.println("---------------------------------");

        Collections.sort(movies, new MovieNoComparator());
    }

    private void PrintUserInfo(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("찾으려는 ID : ");
        String id = scan.nextLine();
        System.out.println();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID().equals(id)) {
                User user = users.get(i);

                System.out.println(user.getID() + "고객님이 발행한 티켓 수: " + user.getTicket().size());
                System.out.println("---------------------------------");
                user.printTicket();
                System.out.println("---------------------------------");
                break;
            }
        }

    }

    public void ReadMovieList() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("MovieList.txt"));
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++) {
            String line = br.readLine();
            String[] tmp = line.split("/");
            movies.add(new Movie(i + 1, tmp[0], Integer.parseInt(tmp[1])));
        }
        br.close();
    }

    public void ReadUserList() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("UserList.txt"));
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++) {
            String line = br.readLine();
            String[] tmp = line.split(" ");
            users.add(new User(tmp[1], tmp[2], Integer.parseInt(tmp[0])));
        }
        br.close();
    }

    public void ReadReservationList() throws IOException{
        try {
            BufferedReader br = new BufferedReader(new FileReader("ReservationList.txt"));

            int membernum = Integer.parseInt(br.readLine());
            for (int i = 0; i < membernum; i++) {
                String id = br.readLine();

                //find user
                User user = null;
                for (int k = 0; k < users.size(); k++) {
                    if (users.get(k).getID().equals(id)) {
                        user = users.get(k);
                        break;
                    }
                }

                int reservenum = Integer.parseInt(br.readLine());
                for (int j = 0; j < reservenum; j++) {
                    String line = br.readLine();
                    String[] tmp = line.split("/");

                    //find movie
                    Movie movie = null;
                    for (int k = 0; k < movies.size(); k++) {
                        if (movies.get(k).getName().equals(tmp[0])) {
                            movie = movies.get(k);
                        }
                    }
                    user.addTicket(new Ticket(movie, tmp[1], Integer.parseInt(tmp[2])));
                }
            }
            br.close();
        }
        catch(FileNotFoundException e){
            return;
        }
    }

    public void WriteUserList() throws IOException{
        PrintWriter pw = new PrintWriter("UserList.txt");
        pw.println(users.size());
        for(int i = 0; i < users.size(); i++){
            User user = users.get(i);
            pw.println(Integer.toString(user.IsManager()) + " " + user.getID() + " " + user.getPW());
        }
        pw.close();
    }

    public void WriteReservationList() throws IOException{
        File out = new File("ReservationList.txt");
        PrintWriter pw = new PrintWriter(new FileOutputStream(out));
        //PrintWriter pw = new PrintWriter("ReservationList.txt");
        pw.println(users.size());
        for(int i = 0; i < users.size(); i++){
            User user = users.get(i);
            pw.println(user.getID());

            Vector<Ticket> tickets = user.getTicket();
            pw.println(tickets.size());
            for(int j = 0; j < tickets.size(); j++){
                Ticket ticket = tickets.get(j);
                pw.println(ticket.getMovie().getName() + "/"
                        + ticket.getSeat() + "/" + ticket.getNum() );
            }
        }
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        Theater theater = new Theater();
        theater.ReadMovieList();
        theater.ReadUserList();
        theater.ReadReservationList();

        while(true){
            Program state = theater.statement;
            switch(state){
                case RESERVATION:
                    theater.Menu();
                    break;

                case USER:
                    theater.UserMenu();
                    break;

                case MOVIELIST:
                    theater.ReserveMenu();
                    break;

                case MANAGER:
                    theater.TheaterMenu();
                    break;

                case END:
                    theater.WriteUserList();
                    theater.WriteReservationList();
                    return;
            }

        }
    }
}
