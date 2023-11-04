// function updateCartMove(bid) {
//     window.location.href = "/pro/updateCartMove/" + bid;
// }
//
// function updateCartAdd(bid) {
//     window.location.href = "/pro/updateCartAdd/" + bid;
// }
//
// window.onload = function () {
//     var vue = new Vue({
//         el: "#cart_div",
//         data: {
//             cart:{}
//         },
//         methods: {
//             getCart:function (){
//                 axios({
//                     method: "post",
//                     url:"/pro/cartInfo",
//                 }).then(function (response){
//                     var data = response.data;
//                     vue.cart=data.cart
//                 }).catch(function (reason){
//                     alert(reason)
//                 })
//             },
//             updateCartMove:function (bid){
//                 axios({
//                     method:"post",
//                     url:"/pro/updateCartMove/" + bid,
//                 }).then(function (response){
//                     vue.getCart()
//                 })
//             },
//             updateCartAdd:function (bid){
//                 axios({
//                     method:"post",
//                     url:"/pro/updateCartAdd/" + bid,
//                 }).then(function (){
//                     vue.getCart()
//                 })
//             }
//         },
//         mounted:function () {
//             this.getCart()
//         }
//
//     });
// }
function editCart(cartItemId,buyCount){
    if (buyCount>=1) {
        window.location.href = 'cart.do?operate=editCart&cartItemId=' + cartItemId + "&buyCount=" + buyCount;
    }else{
        alert("购买数量无法小于等于0");
    }
}