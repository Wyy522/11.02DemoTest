package HomeWork7;


public class t1 {

    @before(id = 0)
    public void xx(){
        System.out.println("xx");
    }
    @before(id = 1)
    public void x(){
        System.out.println("x");
    }
    @test(id = 0)
    public void t(){
        System.out.println("t");
    }
    @test(id = 1)
    public void tt(){
        System.out.println("tt");
    }
    @after(id = 0)
    public void y(){
        System.out.println("y");
    }
    @after(id = 1)
    public void yy(){
        System.out.println("yy");
    }

}
