var app = new Vue({
    el: '#app',
    data: {
        administratorId:'',
        username:'',
        realName:'',
        email:'',
        avatarUrl:'',
        createTimestamp:''
    },
    mounted(){
        console.log('get profile');
        this.getMyProfile();
    },
    methods:{
        handleUpdateClick(){
            console.log('update click');
            this.updateMyProfile();
        },
        getMyProfile(){
            axios.get('/admin/getProfile')
                .then(function (response) {
                    console.log(response);
                    var gp = response.data;
                    app.administratorId = gp.administratorId;
                    app.username = gp.username;
                    app.realName = gp.realName;
                    app.email = gp.email;
                    app.avatarUrl = gp.avatarUrl;
                    app.createTimestamp = gp.createTimestamp;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        updateMyProfile(){
            axios.post('/admin/updateProfile',{
                realName:this.realName,
                email:this.email,
                avatarUrl:this.avatarUrl
            })
                .then(function (response) {
                    console.log(response);
                    alert('更新成功');
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})