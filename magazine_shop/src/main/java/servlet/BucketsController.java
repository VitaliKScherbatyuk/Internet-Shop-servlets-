package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import domain.Bucket;
import domain.Product;
import dto.BucketDto;
import service.BucketService;
import service.ProductService;
import service.implement.BucketServiceImplement;
import service.implement.ProductServiceImplement;

@WebServlet("/buckets")
public class BucketsController extends HttpServlet {

	private BucketService bucketService = BucketServiceImplement.getBucketService();
	private ProductService productService = ProductServiceImplement.getProductService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Bucket> buckets = bucketService.readAll();
		Map<Integer, Product> idToProduct = productService.readAllMap();
		List<BucketDto> listOfBucketDtos = map(buckets, idToProduct);
		
		String json = new Gson().toJson(listOfBucketDtos);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);
	}

	private List<BucketDto> map(List<Bucket> buckets, Map<Integer, Product> idToProduct) {
		return	buckets.stream().map(bucket->{
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucketId = bucket.getId();
			bucketDto.timeOperation = bucket.getTimeOperation();
		   
			Product product = idToProduct.get(bucket.getProductId());
		    bucketDto.name = product.getName();
		    bucketDto.description = product.getDescription();
		    bucketDto.price = product.getPrice();
			
			return bucketDto;
		}).collect(Collectors.toList());
	}

	
}
