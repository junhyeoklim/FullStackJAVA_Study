//package test;
//
//interface Printable {
//    void print();   
//}
//
//class Papers {
//    private String con;
//    public Papers(String s) { con = s; }
//
//    public Printable getPrinter() {
//        return new Printable() {
//            public void print() { System.out.println(con); }
//        };        
//    }
//}
//
//class Test4_1 {
//    public static void main(String[] args) {
//        Papers p = new Papers("서류 내용: 행복합니다.");
//        Printable prn = p.getPrinter();
//        prn.print();
//    }
//}
//
