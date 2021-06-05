import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class ClothesTopLinkc {
	public ClothesTopLinkc() {
		String urlLink = "https://www.elandmall.com/";

		try {
			Desktop.getDesktop().browse(new URI(urlLink));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
} 
