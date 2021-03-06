const AddressShow = {
    template:`
    <div id="app">
        标签：{{tag}} <br>
        内容：{{content}} <br>
        收货人姓名：{{receiverName}} <br>
        收货人手机：{{receiverMobile}} <br>
        <br>
    </div>
    `,
    data(){
        return{
            addressId:'',
            tag:'',
            content:'',
            receiverName:'',
            receiverMobile:''
        }
    },
    mounted(){
        console.log('get addressId');
        
        this.addressId = this.$route.params.addressId;
        if(!this.addressId){
            alert('addressId is null');
            return;
        }
        this.getAddressByAddressId();
    },
    methods:{
        getAddressByAddressId(){
            axios.get('/address/getById',{
                params:{
                    addressId:this.addressId
                }
            })
                .then((response) => {
                    console.log(response);
                    var address = response.data;
                    this.tag = address.tag;
                    this.content = address.content;
                    this.receiverName = address.receiverName;
                    this.receiverMobile = address.receiverMobile;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
}