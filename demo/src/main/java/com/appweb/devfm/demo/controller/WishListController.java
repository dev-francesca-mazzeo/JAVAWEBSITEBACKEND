package com.appweb.devfm.demo.controller;

import com.appweb.devfm.demo.common.ApiResponse;
import com.appweb.devfm.demo.dto.product.ProductDto;
import com.appweb.devfm.demo.entity.Product;
import com.appweb.devfm.demo.entity.User;
import com.appweb.devfm.demo.entity.WishList;
import com.appweb.devfm.demo.services.AuthenticationService;
import com.appweb.devfm.demo.services.ProductService;
import com.appweb.devfm.demo.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.appweb.devfm.demo.constants.EndPoint.*;

@RestController
@RequestMapping(WISHLIST)
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(TOKEN)
    public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("token") String token) {
        int user_id = authenticationService.getUser(token).getId();
        List<WishList> body = wishListService.readWishList(user_id);
        List<ProductDto> products = new ArrayList<ProductDto>();
        for (WishList wishList : body) {
            products.add(ProductService.getDtoFromProduct(wishList.getProduct()));
        }

        return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
    }

    @PostMapping(ADD)
    public ResponseEntity<ApiResponse> addWishList(@RequestBody Product product, @RequestParam("token") String token) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        WishList wishList = new WishList(user, product);
        wishListService.createWishlist(wishList);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Add to wishlist"), HttpStatus.CREATED);

    }


}