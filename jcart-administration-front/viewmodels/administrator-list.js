var app = new Vue({
    el: '#app',
    data: {
        pageInfo: '',
        pageNum: 1,
        selectedAdministrators: []
    },
    computed: {
        selectedAdministratorIds() {
            return this.selectedAdministrators.map(a => a.administratorId);
        }
    },
    mounted() {
        console.log('list');
        this.getAdministrators();
    },
    methods: {
        handlePageChange(value) {
            console.log('page change', value);
            this.pageNum = value;
            this.getAdministrators();
        },
        handleDelete(index, row) {
            console.log('delete click');

            if (confirm("确认删除？")) {
                this.deleteAdministrator(row.administratorId);
            }
        },
        handleDeleteAnyClick() {
            console.log('deleteAny click');
            if (confirm("确认删除？")) {
                this.DeleteAnyAdministrators();
            }
        },
        handleSelectionChange(value) {
            console.log('selection change', value);
            this.selectedAdministrators = value;
        },
        deleteAdministrator(administratorId) {
            axios.post('/admin/delete', administratorId, {
                headers: {
                    'Content-Type': 'application/json'
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
                });
        },
        DeleteAnyAdministrators() {
            axios.post('/admin/deleteAny', this.selectedAdministratorIds)
                .then(function (response) {
                    console.log(response);
                    alert('批删成功');
                    location.reload();
                })
                .catch(function (error) {
                    console.log(error);
                    alert('批删失败');
                });
        },
        getAdministrators() {
            axios.get('/admin/getList', {
                params: {
                    pageNum: this.pageNum
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})