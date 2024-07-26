import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class おぶじぇくとあうとぷっとすとりーむをつかったしりあらいず {
    public static void main(String[] args) {
        ひと hito = new ひと();
        hito.ひとのなまえ = "たろー";
        
        くるま kuruma = new くるま();
        kuruma.うんてんするひと = hito;
        
        ばいく baiku = new ばいく();
        baiku.うんてんするひと = hito;

        しりあらいずようのくらす siriaraizu = new しりあらいずようのくらす();
        siriaraizu.hito = hito;
        siriaraizu.kuruma = kuruma;
        siriaraizu.baiku = baiku;

        System.out.println("シリアライズ前");
        System.out.println(siriaraizu.hito.equals(siriaraizu.kuruma.うんてんするひと));
        System.out.println(siriaraizu.hito.equals(siriaraizu.baiku.うんてんするひと));

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("siriaraizu.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(siriaraizu);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("シリアライズしたよ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("siriaraizu.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            siriaraizu = (しりあらいずようのくらす)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("デシリアライズしたよ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("シリアライズ後");
        System.out.println(siriaraizu.hito.equals(siriaraizu.kuruma.うんてんするひと));
        System.out.println(siriaraizu.hito.equals(siriaraizu.baiku.うんてんするひと));
    }
}