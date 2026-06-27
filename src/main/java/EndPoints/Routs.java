package EndPoints;

public class Routs 
{

      public static class apiendpoints 
      {
            //onboarding//
            public static final String sendOtp = "/user/api/v1/onboarding/send-otp";
            public static final String verifyOTP = "/user/api/v1/onboarding/verify-otp";
            public static final String getUserProfile = "/user/api/v1/onboarding/profile";

            //User Address//
            public static final String postAddUserAddress = "/user/api/v1/user/addresses";
            public static final String getUserAddress = "/user/api/v1/user/addresses";
            public static final String deleteUserAddressById = "/user/api/v1/user/addresses";

            public static final String getUserAddressById = "/user/api/v1/user/addresses";
            
            //category
            public static final String getCategoriesList = "/product/api/v1/category/categories-app";

            //Subcategory
            public static final String getSubCategoriesList = "/product/api/v1/sub-category/{categoryId}";

            //Products//
            public static final String getSpecialOffers = "/product/api/v1/special-offer";
            public static final String getItemDetailsByID = "/product/api/v1/details";

            //WishList//
            public static final String postAddItemToWishList = "/product/api/v1/wishlist";
            public static final String getUserWishList = "/product/api/v1/wishlist";
            public static final String putRemoveItemFromWishList = "/product/api/v1/wishlist";

      }

    
}
