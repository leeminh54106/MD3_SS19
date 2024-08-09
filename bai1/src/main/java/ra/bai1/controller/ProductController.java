package ra.bai1.controller;

import konta.bai1.model.entity.Product;
import konta.bai1.service.ProductService;
import konta.bai1.service.UploadFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UploadFile uploadFile;

    @RequestMapping(value = {"/","listProduct"})
    public String home(Model model){
        List<Product> list = productService.findAll();
        model.addAttribute("list",list);
        return "listProduct";
    }


    @RequestMapping("/initInsertProduct")
    public String initInsertStudent(Model model){
        Product s = new Product();
        model.addAttribute("s",s);
        return "insertProduct";
    }

    @RequestMapping("/insertProduct")
    public String insertStudent(@Valid @ModelAttribute("s")Product s, BindingResult result, @RequestParam("imageFile") MultipartFile file, Model model){
        if(result.hasErrors()){
            model.addAttribute("s",s);
            return "insertProduct";
        }else{
            //upload avatar:
            String urlAvatar = uploadFile.uploadLocal(file);
            s.setImage(urlAvatar);
            boolean bl = productService.save(s);
            if(bl){
                return "redirect:/listProduct";
            }else{
                model.addAttribute("s",s);
                model.addAttribute("error","Insert failed!");
                return "insertProduct";
            }
        }
    }

    @GetMapping("/editProduct/{id}")
    public String viewEdit(@PathVariable Integer id, Model model)
    {
        model.addAttribute("s", productService.findById(id));
        return "editProduct";
    }

    @PostMapping("/editProduct")
    public String editProduct(@Valid @ModelAttribute("s")Product s, BindingResult result,@RequestParam("imageFile") MultipartFile file, Model model){
        if(result.hasErrors()){
            model.addAttribute("s",s);
            return "editProduct";
        }else {
            if (file.getSize()==0){
                s.setImage(productService.findById(s.getId()).getImage());
            }else {
                //upload avatar:
                String urlAvatar = uploadFile.uploadLocal(file);
                s.setImage(urlAvatar);
            }
            productService.update(Product.builder()
                            .id(s.getId())
                            .name(s.getName())
                            .price(s.getPrice())
                            .stock(s.getStock())
                            .created(s.getCreated())
                            .image(s.getImage())
                            .status(s.getStatus())
                    .build());
            return "redirect:/";
        }
    }
}
