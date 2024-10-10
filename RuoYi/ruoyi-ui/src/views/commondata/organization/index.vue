<template>
  <div class="app-container">
   <!--<el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="${comment}" prop="OrganizationID">
        <el-input
          v-model="queryParams.OrganizationID"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="LevelCode">
        <el-input
          v-model="queryParams.LevelCode"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="Name">
        <el-input
          v-model="queryParams.Name"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="CoefficientAltitude">
        <el-input
          v-model="queryParams.CoefficientAltitude"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="RawToClinkerCoff">
        <el-input
          v-model="queryParams.RawToClinkerCoff"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="LegalRepresentative">
        <el-input
          v-model="queryParams.LegalRepresentative"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="Address">
        <el-input
          v-model="queryParams.Address"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="Contacts">
        <el-input
          v-model="queryParams.Contacts"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="ContactInfo">
        <el-input
          v-model="queryParams.ContactInfo"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="CommissioningDate">
        <el-date-picker clearable
          v-model="queryParams.CommissioningDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择${comment}">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="${comment}" prop="Products">
        <el-input
          v-model="queryParams.Products"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="Remarks">
        <el-input
          v-model="queryParams.Remarks"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form> -->

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['commondata:organization:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['commondata:organization:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['commondata:organization:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['commondata:organization:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="organizationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!--<el-table-column label="组织机构" align="center" prop="organizationID" /> -->
      <el-table-column label="生产机构层次码" align="center" prop="levelCode" />
      <el-table-column label="生产机构名称" align="center" prop="name" />
       <el-table-column label="数据库ID" align="center" prop="databaseID" />
      <el-table-column label="生产线类型" align="center" prop="type" />
      <el-table-column label="法人代表" align="center" prop="legalRepresentative" />
      <el-table-column label="生产机构地址" align="center" prop="address" />
      <el-table-column label="联系人" align="center" prop="contacts" />
      <el-table-column label="联系人信息" align="center" prop="contactInfo" />
      <el-table-column label="投产日期" align="center" prop="commissioningDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.commissioningDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="主要产品" align="center" prop="products" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['commondata:organization:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['commondata:organization:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改生产机构对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="组织机构ID" prop="organizationID">
          <el-input v-model="form.organizationID" placeholder="请输入组织机构ID" />
        </el-form-item>
        <el-form-item label="生产机构层次码" prop="levelCode">
          <el-input v-model="form.levelCode" placeholder="请输入生产机构层次码" />
        </el-form-item>
        <el-form-item label="生产机构名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入生产机构名称" />
        </el-form-item>
         <el-form-item label="生产线类型" prop="type">
          <el-input v-model="form.type" placeholder="请输入生产线类型" />
        </el-form-item>
       <!--  <el-form-item label="" prop="coefficientAltitude">
          <el-input v-model="form.coefficientAltitude" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="rawToClinkerCoff">
          <el-input v-model="form.rawToClinkerCoff" placeholder="请输入${comment}" />
        </el-form-item>-->
        <el-form-item label="法人代表" prop="legalRepresentative">
          <el-input v-model="form.legalRepresentative" placeholder="请输入法人代表" />
        </el-form-item>
        <el-form-item label="机构地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入机构地址" />
        </el-form-item>
        <el-form-item label="联系人" prop="contacts">
          <el-input v-model="form.contacts" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系人信息" prop="contactInfo">
          <el-input v-model="form.contactInfo" placeholder="请输入联系人信息" />
        </el-form-item>
        <el-form-item label="投产日期" prop="commissioningDate">
          <el-date-picker clearable
            v-model="form.commissioningDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择投产日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要产品" prop="products">
          <el-input v-model="form.products" placeholder="请输入主要产品" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOrganization, getOrganization, delOrganization, addOrganization, updateOrganization } from "@/api/commondata/organization";

export default {
  name: "Organization",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 生产机构表格数据
      organizationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        OrganizationID: null,
        LevelCode: null,
        Name: null,
        Type: null,
        LevelType: null,
        CoefficientAltitude: null,
        RawToClinkerCoff: null,
        ENABLED: null,
        LegalRepresentative: null,
        Address: null,
        Contacts: null,
        ContactInfo: null,
        CommissioningDate: null,
        Products: null,
        Remarks: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询生产机构列表 */
    getList() {
      this.loading = true;
      listOrganization(this.queryParams).then(response => {
        console.log(response.rows)
        this.organizationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        OrganizationID: null,
        LevelCode: null,
        DatabaseID: null,
        Name: null,
        Type: null,
        LevelType: null,
        CoefficientAltitude: null,
        RawToClinkerCoff: null,
        ENABLED: null,
        LegalRepresentative: null,
        Address: null,
        Contacts: null,
        ContactInfo: null,
        CommissioningDate: null,
        Products: null,
        Remarks: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加生产机构";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrganization(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改生产机构";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            console.log(this.form)
            updateOrganization(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrganization(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除生产机构编号为"' + ids + '"的数据项？').then(function() {
        return delOrganization(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('commondata/organization/export', {
        ...this.queryParams
      }, `organization_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
