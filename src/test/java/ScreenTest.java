//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.Selenide;
//import io.qameta.allure.Attachment;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInfo;
//import org.openqa.selenium.OutputType;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import static com.codeborne.selenide.Selenide.open;
//
//public class ScreenTest extends BaseSettingsTest {
//    @Test
//    public void screenTest(TestInfo info) {
//        Configuration.browser = "chrome";
//        Configuration.browserSize = "390x844";
//        open("http://localhost:3000/");
//    }
//    private void assertScreen(TestInfo info) {
//        String fileName = info.getTestMethod().get().getName();
//        String screenDir = "src/test/resources/screens";
//
//        File okScreenshot = Selenide.screenshot(OutputType.FILE);
//        File actualScreenshot = new File(okScreenshot + fileName);
//
//        if(!actualScreenshot.exists()) {
//            addImgToAllure("actual", actualScreenshot);
//            throw new IllegalArgumentException("Negalimas paliginimas nes niera su kuo liginti");
//        }
//        BufferedImage expectedImage = ImageComparisontUtil.readImageResourseces(screenDir + fileName);
//        BufferedImage actualImage = ImageComparisontUtil.readImageResourseces(okScreenshot.toPath());
//
//        File resultDestination = new File("build/diffs/diff_ + fileName");
//        ImageComparision imageComparision = new ImageComparision(expectedImage, actualImage, resultDestination);
//        ImageCompresionResult result = imageComparision.compareImage();
//
//        if (!result.getImageComparisionState().equals(ImageComparisionState.MATCH)) {
//            addImgToAllure("actual", actualScreenshot);
//            addImgToAllure("expected", okScreenshot);
//            addImgToAllure("diff", resultDestination);
//        }
//        Assertions.assertEquals(ImageComparisionState.MATCH, result.getImageComparisionState());
//    }
//    private void addImgToAllure(String name, File file) {
//        try {
//            Byte[] image = File.readAllBytes(file.toPath());
//            saveScreenshot(name, image);
//        } catch (IOException e) {
//            throw new RuntimeException("Niera failo");
//        }
//    }
//    @Attachment(value = "{name}", type = "image/png")
//    private static Byte[] saveScreenshot(String name, Byte[] image) {
//        return image;
//    }
//}
