import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		try {
			/*
			 * FileOutputStream fos = new FileOutputStream("monfichier.dat"); //
			 * filtre qui permet de manipuler des types Java DataOutputStream
			 * dos = new DataOutputStream(fos); dos.writeDouble(22.5);
			 * dos.writeInt(14); dos.close();
			 * 
			 * FileInputStream fis = new FileInputStream("monfichier.dat");
			 * DataInputStream dis = new DataInputStream(fis);
			 * System.out.println(dis.readDouble());
			 * System.out.println(dis.readInt()); dis.close();
			 */

			// deuxième exemple avec un fichier texte

			FileWriter fw = new FileWriter("monfichier.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			// les methodes de PrintWriter ne retournent pas d'exception
			pw.println("une ligne de texte");
			pw.println("une deuxieme ligne de texte");
			pw.close();

			FileReader fr = new FileReader("monfichier.txt");
			BufferedReader br = new BufferedReader(fr);

			System.out.println(br.readLine());
			System.out.println(br.readLine());

			br.close();

			// quatrième exemple : lecture depuis une url

			URL url = new URL("http://www.lemonde.fr");
			InputStream is = url.openStream();

			Reader isr = new InputStreamReader(is, "ISO-8859-1");

			BufferedReader br2 = new BufferedReader(isr);

			// while(br2.ready()) {
			// System.out.println(br2.readLine());
			// }

			// cinquieme exemple : lecture depuis une url

			Compte compte1 = new Compte("lili@gmail.com", "lili", "lili", LocalDate.now());
			Compte compte2 = new Compte("lulu@gmail.com", "lulu", "lulu", LocalDate.now());
			Compte compte3 = new Compte("lala@gmail.com", "lala", "lala", LocalDate.now());

			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("serial1.txt")));

			oos.writeObject(compte1);
			oos.writeObject(compte2);
			oos.writeObject(compte3);

			oos.flush();

			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("serial1.txt")));

			Compte c1 = null, c2 = null, c3 = null;
			Object o = null;
			try {
				while (true) {

					c1 = (Compte) ois.readObject();
					System.out.println(c1);

				}
			} catch (EOFException e) {

			}

			// System.out.println(c2);
			// System.out.println(c3);

		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
