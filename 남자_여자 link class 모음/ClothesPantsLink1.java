import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class ClothesPantsLink1 {
	public ClothesPantsLink1() {
		String urlLink = "https://shop.descentekorea.co.kr/";

		try {
			Desktop.getDesktop().browse(new URI(urlLink));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
}