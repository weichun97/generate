(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-41d8ddd2"],{"067a":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"generate"},[a("el-form",{ref:e.generateFormRef,attrs:{model:e.generateForm,rules:e.generateFormRules,size:"mini","label-width":"150px"}},[a("el-form-item",{attrs:{label:"选择数据源",prop:"datasourceId"}},[a("el-select",{attrs:{placeholder:"选择数据源"},model:{value:e.generateForm.datasourceId,callback:function(t){e.$set(e.generateForm,"datasourceId",t)},expression:"generateForm.datasourceId"}},e._l(e.datasourceConfigList,(function(t){return a("el-option",{key:t.id,attrs:{label:e.getDatasourceLabel(t),value:t.id}},[a("span",{staticStyle:{float:"left"}},[e._v(e._s(e.getDatasourceLabel(t)))]),a("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"13px"}},[a("el-tooltip",{attrs:{placement:"top",content:"Duplicate"}},[a("el-link",{staticStyle:{"margin-right":"20px"},attrs:{type:"primary",icon:"el-icon-document-copy"},on:{click:function(a){return a.stopPropagation(),e.handleCopy(t)}}})],1),a("el-link",{staticStyle:{"margin-right":"20px"},attrs:{type:"primary",icon:"el-icon-edit"},on:{click:function(a){return a.stopPropagation(),e.handleEdit(t)}}}),a("el-link",{attrs:{type:"danger",icon:"el-icon-delete"},on:{click:function(a){return a.stopPropagation(),e.handleDelete(t)}}})],1)])})),1),a("el-button",{attrs:{type:"text"},on:{click:e.handleCreate}},[e._v("新建数据源")])],1),a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:12}},[a("h4",[e._v("选择表")]),a("el-input",{staticStyle:{"margin-bottom":"10px",width:"100%"},attrs:{"prefix-icon":"el-icon-search",clearable:"",size:"mini",placeholder:"过滤表"},model:{value:e.tableSearch,callback:function(t){e.tableSearch=t},expression:"tableSearch"}}),a("el-table",{attrs:{data:e.tableListData,"row-class-name":e.tableRowClassName},on:{"selection-change":e.onTableListSelect}},[a("el-table-column",{attrs:{type:"selection"}}),a("el-table-column",{attrs:{prop:"name",label:"表名"}}),a("el-table-column",{attrs:{prop:"comment",label:"备注"}})],1)],1),a("el-col",{attrs:{id:"templateSelect",span:12}},[a("h4",[e._v("选择模板")]),a("el-select",{staticStyle:{"margin-bottom":"10px",width:"100%"},attrs:{placeholder:"选择模板所在组",size:"mini"},on:{change:e.onTemplateGroupChange},model:{value:e.templateId,callback:function(t){e.templateId=t},expression:"templateId"}},e._l(e.templateGroups,(function(t){return a("el-option",{key:t.id,attrs:{label:t.name,value:t.id}},[e._v(" "+e._s(t.name)+" ")])})),1),a("el-table",{ref:"templateListSelect",attrs:{data:e.templateListData},on:{"selection-change":e.onTemplateListSelect}},[a("el-table-column",{attrs:{type:"selection"}}),a("el-table-column",{attrs:{prop:"name",label:"模板名称"},scopedSlots:e._u([{key:"default",fn:function(t){return a("span",{},[e._v(" "+e._s(t.row.name)+" ")])}}])})],1),a("el-button",{attrs:{type:"primary"},on:{click:e.onGenerate}},[e._v("生成代码")])],1)],1),a("el-dialog",{attrs:{title:e.saveOrUpdateFormTitle,visible:e.saveOrUpdateFormVisible,"close-on-press-escape":!1,"close-on-click-modal":!1},on:{"update:visible":function(t){e.saveOrUpdateFormVisible=t}}},[a("el-form",{ref:e.saveOrUpdateFormRef,attrs:{model:e.saveOrUpdateForm,rules:e.saveOrUpdateFormRules,size:"mini","label-width":"120px"}},[a("el-form-item",{attrs:{label:"数据库类型",prop:"dbType"}},[a("el-select",{attrs:{filterable:"","default-first-option":""},model:{value:e.saveOrUpdateForm.dbType,callback:function(t){e.$set(e.saveOrUpdateForm,"dbType",t)},expression:"saveOrUpdateForm.dbType"}},e._l(e.dbTypes,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),a("el-form-item",{attrs:{label:"Host",prop:"host"}},[a("el-input",{attrs:{placeholder:"地址","show-word-limit":"",maxlength:"100"},model:{value:e.saveOrUpdateForm.host,callback:function(t){e.$set(e.saveOrUpdateForm,"host",t)},expression:"saveOrUpdateForm.host"}})],1),a("el-form-item",{attrs:{label:"Port",prop:"port"}},[a("el-input",{attrs:{placeholder:"端口","show-word-limit":"",maxlength:"10"},model:{value:e.saveOrUpdateForm.port,callback:function(t){e.$set(e.saveOrUpdateForm,"port",t)},expression:"saveOrUpdateForm.port"}})],1),a("el-form-item",{attrs:{label:"dbName",prop:"dbName"}},[a("el-input",{attrs:{placeholder:"数据库名","show-word-limit":"",maxlength:"64"},model:{value:e.saveOrUpdateForm.dbName,callback:function(t){e.$set(e.saveOrUpdateForm,"dbName",t)},expression:"saveOrUpdateForm.dbName"}})],1),a("el-form-item",{attrs:{label:"Username",prop:"username"}},[a("el-input",{attrs:{placeholder:"用户名","show-word-limit":"",maxlength:"100"},model:{value:e.saveOrUpdateForm.username,callback:function(t){e.$set(e.saveOrUpdateForm,"username",t)},expression:"saveOrUpdateForm.username"}})],1),a("el-form-item",{attrs:{label:"Password",prop:"password"}},[a("el-input",{attrs:{type:"password",placeholder:"密码","show-word-limit":"",maxlength:"100"},model:{value:e.saveOrUpdateForm.password,callback:function(t){e.$set(e.saveOrUpdateForm,"password",t)},expression:"saveOrUpdateForm.password"}})],1),a("el-form-item",{attrs:{label:"删除前缀",prop:"delPrefix"}},[a("el-input",{attrs:{placeholder:"删除前缀（表名sys_user删除前缀sys_对应bean为User）多前缀逗号隔开","show-word-limit":"",maxlength:"200"},model:{value:e.saveOrUpdateForm.delPrefix,callback:function(t){e.$set(e.saveOrUpdateForm,"delPrefix",t)},expression:"saveOrUpdateForm.delPrefix"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"success",loading:e.testConnectLoading},on:{click:e.testConnect}},[e._v("测试连接")]),a("el-button",{attrs:{type:"primary",loading:e.saveOrUpdateLoading},on:{click:e.saveOrUpdate}},[e._v("保存")])],1)],1)],1)],1)],1)])},n=[],o=(a("99af"),a("e9c4"),a("d81d"),a("4de4"),a("d3b7"),a("b0c0"),a("22fe")),s=a("b775");function l(e){return Object(s["a"])({url:"/datasource/list",method:"get",params:e})}function i(e){return Object(s["a"])({url:"/datasource/save",method:"post",data:e})}function c(e){return Object(s["a"])({url:"/datasource/remove/".concat(e),method:"delete"})}function d(e,t){return Object(s["a"])({url:"/datasource/update/".concat(t),method:"put",data:e})}function u(e){return Object(s["a"])({url:"/datasource/test",method:"post",data:e})}var p=a("4f66"),m=a("c621"),f=a("cf45"),h={name:"GenerateConfig",data:function(){return{activeName:"first",dbTypes:o["a"],updateId:null,saveOrUpdateFormTitle:"新建连接",saveOrUpdateFormVisible:!1,saveOrUpdateLoading:!1,saveOrUpdateForm:{},saveOrUpdateFormRef:"saveOrUpdateFormRef",saveOrUpdateFormRules:{dbType:[{required:!0,message:"不能为空",trigger:"blur"}],host:[{required:!0,message:"不能为空",trigger:"blur"}],port:[{required:!0,message:"不能为空",trigger:"blur"}],username:[{required:!0,message:"不能为空",trigger:"blur"}],password:[{required:!0,message:"不能为空",trigger:"blur"}],dbName:[{required:!0,message:"不能为空",trigger:"blur"}]},testConnectLoading:!1,templateId:null,datasourceConfigList:[],generateFormRef:"generateFormRef",generateForm:{datasourceId:null,tableNames:null,templateIds:null},generateFormRules:{datasourceId:[{required:!0,message:"请选择数据源",trigger:"blur"}]},tableSearch:"",tableListData:[],templateGroups:[],templateListData:[],templateListSelect:[],groupId:"",dbTypeConfig:[]}},watch:{"generateForm.datasourceId":function(e){this.showTables()}},created:function(){this.loadDataSource(),this.loadTemplate()},methods:{loadDataSource:function(){var e=this;l().then((function(t){e.datasourceConfigList=t.data,e.generateForm.datasourceId=null!=e.updateId?e.updateId:e.datasourceConfigList.length>0?e.datasourceConfigList[0].id:null,e.generateForm.datasourceId&&e.showTables()}))},getDatasourceLabel:function(e){var t=e.schemaName?"/".concat(e.schemaName):"",a=e.dbDesc?e.dbDesc+"   ":"";return"".concat(a).concat(e.dbName).concat(t," (").concat(e.host,") - ").concat(e.username)},onGenerate:function(e){var t=this;this.$refs.generateFormRef.validate((function(e){e&&(null!=t.generateForm.tableNames&&0!==t.generateForm.tableNames.length||t.$message({type:"error",message:"请选择表"}),null!=t.generateForm.templateIds&&0!==t.generateForm.templateIds.length||t.$message({type:"error",message:"请选择模板"}),localStorage.setItem("generateForm",JSON.stringify(t.generateForm)),t.$router.push({name:"ResultGenerate"}))}))},showTables:function(){var e=this;Object(p["b"])(this.generateForm.datasourceId).then((function(t){e.tableListData=t.data}))},onTableListSelect:function(e){this.generateForm.tableNames=e.filter((function(e){return void 0===e.hidden||!1===e.hidden})).map((function(e){return e.name}))},tableRowClassName:function(e){var t=e.row;e.index;return t.hidden=!1,0===this.tableSearch.length||t.name&&t.name.toLowerCase().indexOf(this.tableSearch.toLowerCase())>-1?"":(t.hidden=!0,"hidden-row")},loadTemplate:function(){var e=this;Object(m["h"])().then((function(t){e.templateGroups=t.data,e.templateId=e.templateGroups.length>0?e.templateGroups[0].id:null,Object(m["b"])({id:e.templateId}).then((function(t){e.templateListData=t.data}))}))},onTemplateGroupChange:function(){var e=this;Object(m["b"])({id:this.templateId}).then((function(t){e.templateListData=t.data}))},onTemplateListSelect:function(e){this.generateForm.templateIds=e.filter((function(e){return void 0===e.hidden||!1===e.hidden})).map((function(e){return e.id}))},testConnect:function(){var e=this;this.$refs.saveOrUpdateFormRef.validate((function(t){t&&(e.testConnectLoading=!0,u(e.saveOrUpdateForm).then((function(){Object(f["b"])(e,"连接数据库成功"),e.testConnectLoading=!1})).catch((function(){console.log(123),e.testConnectLoading=!1})))}))},handleCreate:function(){this.saveOrUpdateFormTitle="新建连接",this.saveOrUpdateForm={},this.saveOrUpdateFormVisible=!0,this.updateId=null},handleCopy:function(e){this.saveOrUpdateFormTitle="".concat(e.host," 复制"),this.saveOrUpdateForm=Object.assign({},this.saveOrUpdateForm,e),this.updateId=null,this.saveOrUpdateFormVisible=!0},handleEdit:function(e){this.saveOrUpdateFormTitle="修改连接",this.saveOrUpdateForm=Object.assign({},this.saveOrUpdateForm,e),this.updateId=e.id,this.saveOrUpdateFormVisible=!0},saveOrUpdate:function(){var e=this;this.$refs.saveOrUpdateFormRef.validate((function(t){t&&(null==e.updateId?e.saveDatasource():e.updateDataSource())}))},saveDatasource:function(){var e=this;this.saveOrUpdateLoading=!0,i(this.saveOrUpdateForm).then((function(){e.resetForm(e.saveOrUpdateFormRef),e.loadDataSource(),e.saveOrUpdateFormVisible=!1,Object(f["b"])(e),e.saveOrUpdateLoading=!1})).catch((function(){e.saveOrUpdateLoading=!1}))},updateDataSource:function(){var e=this;this.saveOrUpdateLoading=!0,d(this.saveOrUpdateForm,this.updateId).then((function(){e.resetForm(e.saveOrUpdateFormRef),e.loadDataSource(),e.saveOrUpdateFormVisible=!1,Object(f["b"])(e),e.saveOrUpdateLoading=!1})).catch((function(){e.saveOrUpdateLoading=!1}))},handleDelete:function(e){var t=this;Object(f["a"])(this,(function(){c(e.id).then((function(){t.loadDataSource(),Object(f["b"])(t)}))}))},resetForm:function(e){this.$refs[e].resetFields()}}},b=h,v=(a("96ac"),a("2877")),g=Object(v["a"])(b,r,n,!1,null,null,null);t["default"]=g.exports},"22fe":function(e,t,a){"use strict";a.d(t,"a",(function(){return r})),a.d(t,"b",(function(){return n}));var r=[{label:"MySQL",value:1}],n=[{label:"JAVA",value:"1"}]},"4f66":function(e,t,a){"use strict";a.d(t,"b",(function(){return n})),a.d(t,"a",(function(){return o}));var r=a("b775");function n(e){return Object(r["a"])({url:"/generate/tables/".concat(e),method:"get"})}function o(e){return Object(r["a"])({url:"/generate/generate",method:"post",data:e})}},"57d2":function(e,t,a){},"96ac":function(e,t,a){"use strict";a("57d2")},c621:function(e,t,a){"use strict";a.d(t,"c",(function(){return n})),a.d(t,"f",(function(){return o})),a.d(t,"i",(function(){return s})),a.d(t,"d",(function(){return l})),a.d(t,"a",(function(){return i})),a.d(t,"j",(function(){return c})),a.d(t,"h",(function(){return d})),a.d(t,"b",(function(){return u})),a.d(t,"g",(function(){return p})),a.d(t,"k",(function(){return m})),a.d(t,"e",(function(){return f}));var r=a("b775");function n(e){return Object(r["a"])({url:"/template/query",method:"get",params:e})}function o(e){return Object(r["a"])({url:"/template/save",method:"post",data:e})}function s(e,t){return Object(r["a"])({url:"/template/update/".concat(t),method:"put",data:e})}function l(e){return Object(r["a"])({url:"/template/remove/".concat(e),method:"delete"})}function i(e){return Object(r["a"])({url:"/template/customFields/".concat(e),method:"get"})}function c(e,t){return Object(r["a"])({url:"/template/updateCustomFields/".concat(t),method:"put",data:e})}function d(){return Object(r["a"])({url:"/template/select",method:"get"})}function u(e){return Object(r["a"])({url:"/template/listDetail",method:"get",params:e})}function p(e){return Object(r["a"])({url:"/template/saveDetail",method:"post",data:e})}function m(e,t){return Object(r["a"])({url:"/template/updateDetail/".concat(t),method:"put",data:e})}function f(e){return Object(r["a"])({url:"/template/removeDetail/".concat(e),method:"delete"})}},cf45:function(e,t,a){"use strict";function r(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"操作成功";e.$message({type:"success",message:t})}function n(e,t){e.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(t)}a.d(t,"b",(function(){return r})),a.d(t,"a",(function(){return n}))},e9c4:function(e,t,a){var r=a("23e7"),n=a("d066"),o=a("d039"),s=n("JSON","stringify"),l=/[\uD800-\uDFFF]/g,i=/^[\uD800-\uDBFF]$/,c=/^[\uDC00-\uDFFF]$/,d=function(e,t,a){var r=a.charAt(t-1),n=a.charAt(t+1);return i.test(e)&&!c.test(n)||c.test(e)&&!i.test(r)?"\\u"+e.charCodeAt(0).toString(16):e},u=o((function(){return'"\\udf06\\ud834"'!==s("\udf06\ud834")||'"\\udead"'!==s("\udead")}));s&&r({target:"JSON",stat:!0,forced:u},{stringify:function(e,t,a){var r=s.apply(null,arguments);return"string"==typeof r?r.replace(l,d):r}})}}]);