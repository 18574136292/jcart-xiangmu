var app = new Vue({
    el: '#app',
    data: {
        customerId:'',
        addresses:[]
    },
    mounted(){
        console.log('get customerId');
        var url = new URL(location.href);
        this.customerId = url.searchParams.get('customerId');
        if(!this.customerId){
            alert('customerId is null');
            return;
        }
        this.getAddressAllByCustomerId();
    },
    methods:{
        getAddressAllByCustomerId(){
            axios.get('/address/getListByCustomerId',{
                params:{
                    customerId:this.customerId
                }
            })
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