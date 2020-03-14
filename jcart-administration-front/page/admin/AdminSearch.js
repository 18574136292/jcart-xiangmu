const AdminSearch = {
    template:`
    <div id="app">
        <el-button type="danger" @click="handleDeleteAnyClick">批量删除</el-button>
        <el-table :data="pageInfo.list" style="width: 100%" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55">
            </el-table-column>
            <el-table-column prop="administratorId" label="Id">
            </el-table-column>
            <el-table-column prop="username" label="用户名">
            </el-table-column>
            <el-table-column prop="realName" label="姓名">
            </el-table-column>
            <el-table-column label="状态">
                <template slot-scope="scope">
                    {{statuses[scope.row.status]}}
                </template>
            </el-table-column>
            <el-table-column prop="createTimestamp" label="创建时间">
                <template slot-scope="scope">
                    {{(new Date(scope.row.createTimestamp)).toLocaleString()}}
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        </el-table>

        <el-pagination layout="prev, pager, next" :total="pageInfo.total" @current-change="handlePageChange">
        </el-pagination>
    </div>
    `,
    data(){
        return {
            pageInfo: '',
            pageNum: 1,
            selectedAdministrators: [],
            statuses:['禁用','启用']
        }
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
                .then((response) => {
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
                .then((response) => {
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
                .then((response) => {
                    console.log(response);
                    this.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
}