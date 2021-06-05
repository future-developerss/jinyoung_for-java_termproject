import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class ClothesShoesLink1 {
	public ClothesShoesLink1() {
		String urlLink = "http://www.elcanto.co.kr/";

		try {
			Desktop.getDesktop().browse(new URI(urlLink));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
}