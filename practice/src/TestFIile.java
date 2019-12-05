import java.io.File;

public class TestFIile {
    public static void main(String[] args) {
        File file=new File("F://");
        TestFIile testFIile=new TestFIile();
        testFIile.printFile(file);
    }
    public void printFile(File file){
        String name = file.getName();
        boolean directory = file.isDirectory();
        if(directory){
            File[] files = file.listFiles();
            for (File f:
                 files) {
                printFile(f);
                System.out.println(name);
            }
        }
        System.out.println(name);

    }
}
