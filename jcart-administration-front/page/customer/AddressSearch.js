const AddressSearch = {
    template:`
    <div id="app">
        <el-table :data="addresses" style="width: 100%">
            <el-table-column prop="tag" label="标签">
            </el-table-column>
            <el-table-column prop="content" label="内容">
            </el-table-column>
            <el-table-column prop="receiverName" label="收货人姓名">
            </el-table-column>
            <el-table-column prop="receiverMobile" label="收货人手机">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                     <el-button size="mini" @click="handleShow(scope.$index, scope.row)">详情</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
    `,
    data(){
        return{
            customerId:'',
            addresses:[]
        }
    },
    mounted(){
        console.log('get customerId');

        this.customerId = this.$route.params.customerId;
        if(!this.customerId){
            alert('customerId is null');
            return;
        }
        this.getAddressAllByCustomerId();
    },
    methods:{
        handleShow(index,row){
            console.log('address show');
            this.$router.push('/address/getById/' + row.addressId);
        },
        getAddressAllByCustomerId(){
            axios.get('/address/getListByCustomerId',{
                params:{
                    customerId:this.customerId
                }
            })
                .then((response) => {
                    console.log(response);
                    this.addresses = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
}