import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File f = new File("MyFile.txt");
        File d = new File("ttt");
        d.mkdir();

        if (d.isDirectory()) {
            String[] ds = d.list();
            for (int i=0; i<ds.length; i++) {
                System.out.println(ds[i]);
            }
        }

        System.out.println(f.getAbsolutePath());

        Boolean isDeleted = f.delete();
    }
}