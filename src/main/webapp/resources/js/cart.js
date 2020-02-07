function addCart(productId) {
    $.ajax({
        url: "/saleweb/api/cart",
        type: "POST",
        data: {
            productId: productId,
            num: 1
        },
        success: function (data) {
            var a = $(".product-count").text();
            a = a === "" ? 0:parseInt(a);
            $(".product-count").text(a + 1);
        },
        error: function (jqXHR) {
            console.info(jqXHR);
        }
    });
}
