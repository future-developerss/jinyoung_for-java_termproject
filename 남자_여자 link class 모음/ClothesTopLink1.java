import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class ClothesTopLink1 {
	public ClothesTopLink1() {
		String urlLink = "https://www.dressinn.com/%EC%9C%A0%ED%96%89/lacoste/645/m";

		try {
			Desktop.getDesktop().browse(new URI(urlLink));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
} 