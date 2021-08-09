$(document).ready(function () {
    $('.amt').each(
        function() {
            $(this).text(
                numeral($(this).text()).format(
                    '0,0')
                + " VND");
        });


    $(".btn-star").click(function () {
        /*closest("div") thẻ div cha gần nhất*/
        var productId = $(this).closest("div").attr("data-id");
        console.log(productId);
        $.ajax({
            type: "GET",
            url : "/product/addToFavorite/"+productId,
            success: function (res) {
                if(res){
                    alert("Thêm thành công")
                }else{
                    alert(" Đã có sẵn")
                }

            }
        });
    });
    //Mở hộp thoại và lấy id của sản phẩm
    $(".btn-open-dialog").click(function () {
        var productId = $(this).closest("div").attr("data-id");
        /*Đưa id của sản phẩm vào trong ô input #id của modal*/
        $("#myModal #id").val(productId);/*Set data id vào ô input*/
    });

    $(".btn-send").click(function () {
        /*Dùng json để chứa nội dung*/
        var form = {
            id               : $("#myModal #id").val(),
            from        : $("#myModal #emailFrom").val(),
            to          : $("#myModal #emailTo").val(),
            body          : $("#myModal #comment").val()
        }
        $.ajax({
            type: "POST",
            url : "/product/send-to-friend", /*Gọi url truyền data dạng json lên server*/
            data : form,/*Khi lên server chưa url /product/send-to-friend thì dùng MailInfo để hứng thông tin*/
            success: function (res) {
                if(res){
                    $("[data-dismiss]").click();/*Click vào các thẻ có thuộc tính data-dismiss*/
                    alert("Gửi thành công")
                }else{
                    alert(" Không gửi được")
                }

            }
        });


    });

    $(".btn-cart").click(function () {
        var productId = $(this).closest("div").attr("data-id");
        $.ajax({
            type: "GET",
            url : "/cart/addToCart/"+productId,//Truyền productId lên server khi click ajax
            success: function (res) {
                $("#cart-cnt").html(res[0]);
                $("#cart-amt").html(res[1]);
                $('#cart-amt').each(
                    function() {
                        $(this).text(
                            numeral($(this).text()).format(
                                '0,0')
                            + " VND");
                    });

            }
        });
        var img = $(this).closest(".thumbnail").find("a>img");
        var options = {to:'#cart-img-js',className:'cart-fly'}
        var cartcss = '.cart-fly{\n' +
            '            background-image: url(" '+img.attr("src")+'  ");\n' +
            '        background-size: 100% 100%;\n' +
            '        }';
        $("style#cartcss").html(cartcss);
        img.effects('transfer',options,1000);
    });

    $(".btn-clear-cart").click(function (){
        $.ajax({
            type: "GET",
            url : "/cart/clear",
            success: function (res) {
                $("#cart-cnt").html(0);
                $("#cart-amt").html(0);
                $('#cart-amt').each(
                    function() {
                        $(this).text(
                            numeral($(this).text()).format(
                                '0,0')
                            + " VND");
                    });
                $("table>tbody").html("");
            }
        });
    });
    $(".btn-cart-remove").click(function (){
        var productId = $(this).closest("tr").attr("data-id");
        $.ajax({
            url : "/cart/remove/"+productId,
            success: function (res) {
                $("#cart-cnt").html(res[0]);
                $("#cart-amt").html(res[1]);
                $('#cart-amt').each(
                    function() {
                        $(this).text(
                            numeral($(this).text()).format(
                                '0,0')
                            + " VND");
                    });
            }
        });
        $(this).closest("tr").remove();
    });
    $("tr[data-id] input").on("input",function () {
        var id = $(this).closest("tr").attr("data-id");
        var price = $(this).closest("tr").attr("data-price");
        var qty = $(this).val();
        $.ajax({
            url : `/cart/update/${id}/${qty}`,/*` ` : Nó cũng là biểu diển chuỗi*/
            success: function (res) {
                $("#cart-cnt").html(res[0]);
                $("#cart-amt").html(res[1]);
                $('#cart-amt').each(
                    function() {
                        $(this).text(
                            numeral($(this).text()).format(
                                '0,0')
                            + " VND");
                    });
            }
        });
        var amt = parseInt(price) * qty;
        $(this).closest("tr").find(".amt").html(amt);
        $('.amt').each(
            function() {
                $(this).text(
                    numeral($(this).text()).format(
                        '0,0')
                    + " VND");
            });
    });


});

/*success: function (response) {
 Khi server phản hồi về cho client
            }*/
