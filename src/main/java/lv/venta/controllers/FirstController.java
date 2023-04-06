package lv.venta.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.models.Product;

@Controller
public class FirstController {
	//TODO izveidot sarakstu priekš produktiem 
	private ArrayList<Product> allProducts = new ArrayList<>(Arrays.asList(new Product(1, "Ābols", 3.99f, "Sarkans", 3), new Product(2, "Burkāns", 0.99f, "Oranžs", 2), new Product(3, "Gurķis", 1.12f, "Zaļš", 3)));
	
	
	@GetMapping("/hello") // tiks izsaukta, ja url būs localhost:8080/hello
	public String helloFunc() {
		System.out.println("Mans pirmais kontrolieris ir nostrādājis");
		return "hello-page"; // tiks parādīta hello-page.html lapa
	}

	@GetMapping("/msg") // tiks izsaukta, ja url būs localhost:8080/msg
	public String msgFunc(Model model) {
		model.addAttribute("myMsg", "Te ziņa no manis");
		model.addAttribute("myDate", "23.03.2023.");
		return "msg-page"; // tiks parādīta msg-pagr.html lapa un tajā parādīsies myMsga un myDate
	}

	@GetMapping("/product") // tiks izsaukta, ja url būs localhost:8080/product
	public String productFunc(Model model) {
		Product prod = new Product(1, "Ābols", 3.99f, "Sarkans", 3);
		model.addAttribute("myProduct", prod);
		return "product-page"; // tiks parādīta msg-pagr.html lapa un tajā parādīsies
	}
	
	//TODO /product?title=Ābols
	@GetMapping ("/productOne") //localhost:8080/productOne?title=Ābols
	public String productByParamFunc(@RequestParam("title") String title, Model model) {
		if(title != null) {
			for (Product temp : allProducts) {
				if(temp.getTitle().equals(title)) {
					model.addAttribute("myProduct", temp);
					return "product-page";
				}
			}
		}
		return "error-page";  //paradus error-page.html lapu
 	}
	
	//TODO /product/Ābols
	@GetMapping ("/product/{title}") //localhost:8080/product/Ābols
	public String productByParamFunc2(@PathVariable("title") String title, Model model) {
		if(title != null) {
			for (Product temp : allProducts) {
				if(temp.getTitle().equals(title)) {
					model.addAttribute("myProduct", temp);
					return "product-page";
				}
			}
		}
		return "error-page";  //paradus error-page.html lapu
 	}
	
	//TODO kotrolieri, kas atgriž visus produktus 
	//TODO uztaisit html lapu, kas var visus produktus attelot
	
	
	
	
	//TODO kontrolieri, kas izfiltrē visus produktus kuru cena ir mazāka par 2e
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}