package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping(value = "/")
	public String getMethodName(Model model) {

		List<Product> listProducts = new ArrayList<>();

		productRepository.findAll().forEach(product -> {
			listProducts.add(product);
		});

		model.addAttribute("listProducts", listProducts);
		return "index";
	}

	@GetMapping(value = "/add")
	public String adNewMethodName(Model model) {

		Product product = new Product();

		model.addAttribute("product", product);

		return "add";
	}

	@PostMapping(value = "/add")
	public String saveNewProduct(@ModelAttribute("product") Product product) {
		// TODO: process POST request
		Product p = new Product(product.getName(), product.getBrand(), product.getMadein(), product.getPrice());
		productRepository.save(p);
		return "redirect:/";
	}

	@GetMapping(value = "/edit/{id}")
	public String editProduct(@PathVariable("id") long id, Model model) {
		Optional<Product> product = productRepository.findById(id);
		model.addAttribute("id",id);
		model.addAttribute("product", product);
		return "edit";
	}

	@PostMapping(value = "/edit/{id}")
	public String saveEditProduct(@PathVariable("id") long id,@ModelAttribute("product") Product product) {
		// TODO: process POST request
		Optional<Product> productData = productRepository.findById(id);
		
		if(productData.isPresent()) {
			Product _product = productData.get();
			_product.setName(product.getName());
			_product.setBrand(product.getBrand());
			_product.setMadein(product.getMadein());
			_product.setPrice(product.getPrice());
			productRepository.save(_product);
		}
		return "redirect:/";
	}

	@GetMapping(value = "delete/{id}")
	public String deleteMethodName(@PathVariable long id) {
		// TODO: process DELETE request

		productRepository.deleteById(id);

		return "redirect:/";
	}

}
