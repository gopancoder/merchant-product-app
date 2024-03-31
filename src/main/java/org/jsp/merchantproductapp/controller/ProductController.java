package org.jsp.merchantproductapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.merchantproductapp.dao.ProductDao;
import org.jsp.merchantproductapp.dto.Product;

public class ProductController {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("===========PRODUCT CART============");
		System.out.println("1.Add Products");
		System.out.println("2.Update Product");
		System.out.println("3.Find Products By Merchant Id");
		System.out.println("4.Find Products by Categoy");
		System.out.println("5.Find Products by Brand");
		System.out.println();
		System.out.println("Enter your choice:");
		switch (sc.nextInt()) {
		case 1: {
			Product product = new Product();
			System.out.println("Enter Merchant id to add products:");
			int merchant_id = sc.nextInt();

			System.out.println("Enter Product Name,Brand,Category,Description,Img_url and Cost:");
			product.setName(sc.next());
			product.setBrand(sc.next());
			product.setCategory(sc.next());
			product.setDescription(sc.next());
			product.setImage_url(sc.next());
			product.setCost(sc.nextDouble());

			product = productDao.saveProduct(product, merchant_id);
			if (product != null) {
				System.out.println("Product added with  id:" + product.getId());
			} else {
				System.err.println("Can not add Product as Merchant id is invalid..!!");
			}
			break;
		}
		case 2: {
			Product product=new Product();
			System.out.println("Enter updated Product Id,Name,Brand,Category,Description,Img_url and Cost:");
			product.setId(sc.nextInt());
			product.setName(sc.next());
			product.setBrand(sc.next());
			product.setCategory(sc.next());
			product.setDescription(sc.next());
			product.setImage_url(sc.next());
			product.setCost(sc.nextDouble());

			product = productDao.updateProduct(product);
			if (product != null) {
				System.out.println("Product Updated with  id:" + product.getId());
			} else {
				System.err.println("Can not update Product as Product id is invalid..!!");
			}
			break;
		}
		case 3: {
			System.out.println("Enter Merchant id to display Products:");
			int merchant_id = sc.nextInt();
			List<Product> products = productDao.findProductsByMerchantId(merchant_id);
			if (products.isEmpty()) {
				System.err.println("No Product found for entered Merchant Id..!!");
			} else {
				for (Product p : products) {
					System.out.println(p);
				}
			}
			break;
		}
		case 4: {
			System.out.println("Enter Product Category Name:");
			String category = sc.next();
			List<Product> products = productDao.findByCategoy(category);
			if (products.isEmpty()) {
				System.err.println("No Product found for entered Category..!!");
			} else {
				for (Product p : products) {
					System.out.println(p);
				}
			}
			break;
		}
		case 5: {
			System.out.println("Enter Product Brand Name:");
			String brand = sc.next();
			List<Product> products = productDao.findByBrand(brand);
			if (products.isEmpty()) {
				System.err.println("No Product found for entered Brand..!!");
			} else {
				for (Product p : products) {
					System.out.println(p);
				}
			}
			break;
		}
		default: {
			sc.close();
			System.err.println("Invalid choice number..!!");
			break;
		}

		}
	}

}
