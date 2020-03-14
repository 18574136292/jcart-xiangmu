const AdminCreate = {
    template:`
    <div id="app">
        <el-input v-model="username" placeholder="请输入用户名"></el-input>
        <el-input v-model="password" placeholder="请输入密码"></el-input>
        <el-input v-model="realName" placeholder="请输入姓名"></el-input>
        <el-input v-model="email" placeholder="请输入邮箱"></el-input>
        <!--<el-input v-model="avatarUrl" placeholder="请输入头像"></el-input>-->
        <el-select v-model="selectedStatus" placeholder="请选择状态">
            <el-option v-for="item in statuses" :key="item.value" :label="item.label" :value="item.value">
            </el-option>
        </el-select>
        <br>
        <el-upload ref="uploadMain" action="" :http-request="uploadMainImage" :limit="1" accept="image/*"
                   :auto-upload="false" :on-change="handleOnMainChange" :file-list="mainFileList">
            <el-button slot="trigger" size="small" type="primary">请选择头像</el-button>
            <el-button size="small" type="success" @click="handleUploadMainClick">上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
        </el-upload>
        上传后主图：<el-link type="primary">{{avatarUrl}}</el-link><br>
        <el-image style="width: 100px; height: 100px" :src="avatarUrl" :fit="fit"></el-image>
        <br>
        <el-button type="primary" @click="handleCreateClick">创建</el-button>
    </div>
    `,
    data(){
        return {
            username:'',
            password:'',
            realName:'',
            email:'',
            avatarUrl:'',
            selectedAvatarUrl:'',
            selectedStatus:1,
            statuses:[
                {value:0,label:'禁用'},
                {value:1,label:'启用'},
            ],
            mainFileList:[]
        }
    },
    methods:{
        handleOnMainChange(value){
            this.selectedAvatarUrl=value.raw;
        },
        handleUploadMainClick(){
            console.log('handleUploadMainClick');
            this.uploadMainImage();
        },
        uploadMainImage(){
            var formData = new FormData();
            formData.append("image",this.selectedAvatarUrl);

            axios.post('/image/upload',formData,{
                headers:{
                    'Content-Type':'multipart/form-data'
                }
            })
                .then((response) => {
                    console.log(response);
                    this.avatarUrl = response.data;
                    alert('上传成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('上传失败');
                })
        },
        handleCreateClick() {
            console.log('create click');
            this.createAdministrator();
        },
        createAdministrator(){
            axios.post('/admin/create',{
                username:this.username,
                password:this.password,
                realName:this.realName,
                email:this.email,
                avatarUrl:this.avatarUrl,
                status:this.selectedStatus
            })
                .then((response) => {
                    console.log(response)
                    alert('创建成功');
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
}