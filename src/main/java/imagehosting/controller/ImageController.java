package imagehosting.controller;

import imagehosting.HardCodedImage;
import imagehosting.model.Image;
import imagehosting.service.ImageService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.applet.Applet;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private HardCodedImage hardCodedImage;

    //This method displays all the images in the user home page after successful login
    @RequestMapping("images")
    public String getUserImages(Model model) {
        Image images = imageService.getOneImage();
        model.addAttribute("images", images);
        return "images";
    }

    @RequestMapping("/images/{title}")
    public String showImage(@PathVariable("title") String title, Model model) {

        Date date = new Date();
        Image image = null;
        if (title.equals("Dr. Strange")) {
            image = new Image(1, "Dr. Strange", hardCodedImage.getDrStrange(), date, "Dr. Strange has a time stone");
        } else if (title.equals("SpiderMan")) {
            image = new Image(2, "SpiderMan", hardCodedImage.getSpiderMan(), date, "Spider man dies in Infinity War");
        }
        model.addAttribute("image", image);
        return "images/image";
    }
   
}
