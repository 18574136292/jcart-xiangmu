var app = new Vue({
    el: '#app',
    data: {
        addresses:[]
    },
    mounted(){
        console.log('address list');
        this.getMyAddress();
    },
    methods:{
        handleDelete(index,row){
            console.log('delete click');
            if(confirm("是否要删除该地址")){
                this.deleteAddress(row.addressId);
            }
        },
        deleteAddress(addressId){
            axios.post('/address/delete',addressId,{
                headers:{
                    'Content-Type':'application/json'
                }
            })
                .then(function (response) {
                    console.log(response);
                    alert('删除成功');
                    location.reload();
                })
                .catch(function (error) {
                    console.log(error);
                    alert('删除失败');
                })
        },
        getMyAddress(){
            axios.get('/address/getAddressByCustomerId')
                .then(function (response) {
                    console.log(response);
                    app.addresses = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})