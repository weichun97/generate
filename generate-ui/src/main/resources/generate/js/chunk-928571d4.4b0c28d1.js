(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-928571d4"],{"03c7":function(t,e,a){},"651f":function(t,e,a){"use strict";a("03c7")},a434:function(t,e,a){"use strict";var n=a("23e7"),i=a("23cb"),l=a("a691"),o=a("50c4"),r=a("7b0b"),s=a("65f0"),u=a("8418"),c=a("1dde"),d=a("ae40"),p=c("splice"),f=d("splice",{ACCESSORS:!0,0:0,1:2}),m=Math.max,h=Math.min,b=9007199254740991,v="Maximum allowed length exceeded";n({target:"Array",proto:!0,forced:!p||!f},{splice:function(t,e){var a,n,c,d,p,f,g=r(this),y=o(g.length),O=i(t,y),F=arguments.length;if(0===F?a=n=0:1===F?(a=0,n=y-O):(a=F-2,n=h(m(l(e),0),y-O)),y+a-n>b)throw TypeError(v);for(c=s(g,n),d=0;d<n;d++)p=O+d,p in g&&u(c,d,g[p]);if(c.length=n,a<n){for(d=O;d<y-n;d++)p=d+n,f=d+a,p in g?g[f]=g[p]:delete g[f];for(d=y;d>y-n+a;d--)delete g[d-1]}else if(a>n)for(d=y-n;d>O;d--)p=d+n-1,f=d+a-1,p in g?g[f]=g[p]:delete g[f];for(d=0;d<a;d++)g[d+O]=arguments[d+2];return g.length=y-n+a,c}})},a9e2:function(t,e,a){"use strict";a("d375")},c621:function(t,e,a){"use strict";a.d(e,"c",(function(){return i})),a.d(e,"f",(function(){return l})),a.d(e,"i",(function(){return o})),a.d(e,"d",(function(){return r})),a.d(e,"a",(function(){return s})),a.d(e,"j",(function(){return u})),a.d(e,"h",(function(){return c})),a.d(e,"b",(function(){return d})),a.d(e,"g",(function(){return p})),a.d(e,"k",(function(){return f})),a.d(e,"e",(function(){return m}));var n=a("b775");function i(t){return Object(n["a"])({url:"/template/query",method:"get",params:t})}function l(t){return Object(n["a"])({url:"/template/save",method:"post",data:t})}function o(t,e){return Object(n["a"])({url:"/template/update/".concat(e),method:"put",data:t})}function r(t){return Object(n["a"])({url:"/template/remove/".concat(t),method:"delete"})}function s(t){return Object(n["a"])({url:"/template/customFields/".concat(t),method:"get"})}function u(t,e){return Object(n["a"])({url:"/template/updateCustomFields/".concat(e),method:"put",data:t})}function c(){return Object(n["a"])({url:"/template/select",method:"get"})}function d(t){return Object(n["a"])({url:"/template/listDetail",method:"get",params:t})}function p(t){return Object(n["a"])({url:"/template/saveDetail",method:"post",data:t})}function f(t,e){return Object(n["a"])({url:"/template/updateDetail/".concat(e),method:"put",data:t})}function m(t){return Object(n["a"])({url:"/template/removeDetail/".concat(t),method:"delete"})}},c740:function(t,e,a){"use strict";var n=a("23e7"),i=a("b727").findIndex,l=a("44d2"),o=a("ae40"),r="findIndex",s=!0,u=o(r);r in[]&&Array(1)[r]((function(){s=!1})),n({target:"Array",proto:!0,forced:s||!u},{findIndex:function(t){return i(this,t,arguments.length>1?arguments[1]:void 0)}}),l(r)},cf45:function(t,e,a){"use strict";function n(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"操作成功";t.$message({type:"success",message:e})}function i(t,e){t.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(e)}a.d(e,"b",(function(){return n})),a.d(e,"a",(function(){return i}))},d375:function(t,e,a){},da5e:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"filter-container"},[a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px"},attrs:{placeholder:"模板组",clearable:""},model:{value:t.listParam.name,callback:function(e){t.$set(t.listParam,"name",e)},expression:"listParam.name"}}),a("el-button",{staticClass:"filter-item",attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.handleFilter}},[t._v(" 查询 ")]),a("el-button",{staticClass:"filter-item",attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.handleResetQuery}},[t._v(" 重置 ")]),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"10px"},attrs:{type:"primary",icon:"el-icon-edit"},on:{click:t.handleCreate}},[t._v(" 新增 ")])],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],attrs:{data:t.list,"element-loading-text":"Loading",border:"",fit:"","highlight-current-row":""}},[a("el-table-column",{attrs:{align:"center",label:"序号",width:"95"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(" "+t._s(e.$index+1)+" ")]}}])}),a("el-table-column",{attrs:{label:"模板组"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(" "+t._s(e.row.name)+" ")]}}])}),a("el-table-column",{attrs:{label:"根目录"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(" "+t._s(e.row.baseDir)+" ")]}}])}),a("el-table-column",{attrs:{align:"center",prop:"created_at",label:"创建时间",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("i",{staticClass:"el-icon-time"}),a("span",[t._v(t._s(e.row.createTime))])]}}])}),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.handleDetail(e.row)}}},[t._v("详情")]),a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.handleCustom(e.row)}}},[t._v("自定义")]),a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.handleEdit(e.row)}}},[t._v("编辑")]),a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.handleDelete(e.row)}}},[t._v("删除")])]}}])})],1),a("Pagination",{attrs:{total:t.total,page:t.listParam.current,limit:t.listParam.size},on:{"update:page":function(e){return t.$set(t.listParam,"current",e)},"update:limit":function(e){return t.$set(t.listParam,"size",e)},pagination:t.fetchData}}),a("el-dialog",{attrs:{title:t.saveOrUpdateFormTitile,visible:t.saveOrUpdateFormVisible},on:{"update:visible":function(e){t.saveOrUpdateFormVisible=e}}},[a("el-form",{ref:t.saveOrUpdateFormRef,attrs:{model:t.saveOrUpdateForm,"status-icon":"",rules:t.saveOrUpdateFormRules,"label-width":"100px"}},[a("el-form-item",{attrs:{label:"模板名",prop:"name"}},[a("el-input",{attrs:{type:"text",autocomplete:"off"},model:{value:t.saveOrUpdateForm.name,callback:function(e){t.$set(t.saveOrUpdateForm,"name",e)},expression:"saveOrUpdateForm.name"}})],1),a("el-form-item",{attrs:{label:"根目录",prop:"baseDir"}},[a("el-input",{attrs:{type:"text",autocomplete:"off"},model:{value:t.saveOrUpdateForm.baseDir,callback:function(e){t.$set(t.saveOrUpdateForm,"baseDir",e)},expression:"saveOrUpdateForm.baseDir"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary",loading:t.saveOrUpdateLoading},on:{click:function(e){return t.saveOrUpdateTemplate()}}},[t._v("提交")]),a("el-button",{on:{click:function(e){t.saveOrUpdateFormVisible=!1}}},[t._v("取消")])],1)],1)],1),a("el-dialog",{attrs:{title:t.customFieldTableDialogTitle,visible:t.customFieldTableDialogVisible},on:{"update:visible":function(e){t.customFieldTableDialogVisible=e}}},[a("el-button",{attrs:{type:"primary"},on:{click:t.addNewField}},[t._v("添加")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.editModeEnabled=!0}}},[t._v("编辑")]),a("el-button",{attrs:{type:"primary"},on:{click:t.saveFields}},[t._v("保存")]),a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.customFieldTableData}},[a("el-table-column",{attrs:{prop:"key",label:"key"},scopedSlots:t._u([{key:"default",fn:function(e){var n=e.row;return a("editable-cell",{attrs:{"can-edit":t.editModeEnabled},model:{value:n.key,callback:function(e){t.$set(n,"key",e)},expression:"row.key"}},[a("span",{attrs:{slot:"content"},slot:"content"},[t._v(t._s(n.key))])])}}])}),a("el-table-column",{attrs:{prop:"value",label:"value"},scopedSlots:t._u([{key:"default",fn:function(e){var n=e.row;return a("editable-cell",{attrs:{"can-edit":t.editModeEnabled},model:{value:n.value,callback:function(e){t.$set(n,"value",e)},expression:"row.value"}},[a("span",{attrs:{slot:"content"},slot:"content"},[t._v(t._s(n.value))])])}}])}),t.editModeEnabled?a("el-table-column",{attrs:{label:"操作",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.handleDeleteField(e.row)}}},[t._v("删除")])]}}],null,!1,2238077096)}):t._e()],1)],1)],1)},i=[],l=(a("a434"),a("c740"),a("e9c4"),a("c621")),o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"pagination-container",class:{hidden:t.hidden}},[a("el-pagination",t._b({attrs:{background:t.background,"current-page":t.currentPage,"page-size":t.pageSize,layout:t.layout,"page-sizes":t.pageSizes,total:t.total},on:{"update:currentPage":function(e){t.currentPage=e},"update:current-page":function(e){t.currentPage=e},"update:pageSize":function(e){t.pageSize=e},"update:page-size":function(e){t.pageSize=e},"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}},"el-pagination",t.$attrs,!1))],1)},r=[];a("a9e3");Math.easeInOutQuad=function(t,e,a,n){return t/=n/2,t<1?a/2*t*t+e:(t--,-a/2*(t*(t-2)-1)+e)};var s=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function u(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function c(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function d(t,e,a){var n=c(),i=t-n,l=20,o=0;e="undefined"===typeof e?500:e;var r=function t(){o+=l;var r=Math.easeInOutQuad(o,n,i,e);u(r),o<e?s(t):a&&"function"===typeof a&&a()};r()}var p={name:"Pagination",props:{total:{required:!0,type:Number},page:{type:Number,default:1},limit:{type:Number,default:20},pageSizes:{type:Array,default:function(){return[10,20,30,50]}},layout:{type:String,default:"total, sizes, prev, pager, next, jumper"},background:{type:Boolean,default:!0},autoScroll:{type:Boolean,default:!0},hidden:{type:Boolean,default:!1}},computed:{currentPage:{get:function(){return this.page},set:function(t){this.$emit("update:page",t)}},pageSize:{get:function(){return this.limit},set:function(t){this.$emit("update:limit",t)}}},methods:{handleSizeChange:function(t){this.$emit("pagination",{page:this.currentPage,limit:t}),this.autoScroll&&d(0,800)},handleCurrentChange:function(t){this.$emit("pagination",{page:t,limit:this.pageSize}),this.autoScroll&&d(0,800)}}},f=p,m=(a("651f"),a("2877")),h=Object(m["a"])(f,o,r,!1,null,"9b59b9ae",null),b=h.exports,v=a("cf45"),g=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"edit-cell",on:{click:t.onFieldClick}},[t.editMode||t.showInput?t._e():a("el-tooltip",{attrs:{placement:t.toolTipPlacement,"open-delay":t.toolTipDelay,content:t.toolTipContent}},[a("div",{staticClass:"cell-content",class:{"edit-enabled-cell":t.canEdit},attrs:{tabindex:"0"},on:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.onFieldClick(e)}}},[t._t("content")],2)]),t.editMode||t.showInput?a(t.editableComponent,t._g(t._b({ref:"input",tag:"component",on:{focus:t.onFieldClick},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.onInputExit(e)}},model:{value:t.model,callback:function(e){t.model=e},expression:"model"}},"component",t.$attrs,!1),t.listeners),[t._t("edit-component-slot")],2):t._e()],1)},y=[],O=a("ade3"),F=a("5530"),k={name:"EditableCell",inheritAttrs:!1,props:{value:{type:String,default:""},toolTipContent:{type:String,default:"Click to edit"},toolTipDelay:{type:Number,default:500},toolTipPlacement:{type:String,default:"top-start"},showInput:{type:Boolean,default:!1},editableComponent:{type:String,default:"el-input"},closeEvent:{type:String,default:"blur"},canEdit:{type:Boolean,default:!1}},data:function(){return{editMode:!1}},computed:{model:{get:function(){return this.value},set:function(t){this.$emit("input",t)}},listeners:function(){return Object(F["a"])(Object(O["a"])({},this.closeEvent,this.onInputExit),this.$listeners)}},methods:{onFieldClick:function(){var t=this;this.canEdit&&(this.editMode=!0,this.$nextTick((function(){var e=t.$refs.input;e&&e.focus&&e.focus()})))},onInputExit:function(){this.editMode=!1},onInputChange:function(t){this.$emit("input",t)}}},_=k,T=(a("a9e2"),Object(m["a"])(_,g,y,!1,null,null,null)),D=T.exports,w={components:{Pagination:b,EditableCell:D},data:function(){return{total:0,listParam:{current:1,size:10},list:[],listLoading:!0,saveOrUpdateLoading:!1,saveOrUpdateFormRef:"saveOrUpdateFormRef",saveOrUpdateFormTitile:"新增",saveOrUpdateFormVisible:!1,updateId:null,saveOrUpdateForm:{name:null},saveOrUpdateFormRules:{name:[{required:!0,message:"请输入模板名",trigger:"blur"},{min:1,max:20,message:"长度在 1 到 20 个字符",trigger:"blur"}],baseDir:[{pattern:/^([a-zA-Z_]+[a-zA-Z0-9_]*[a-zA-Z_]*)*(\/?[a-zA-Z_]+[a-zA-Z0-9_]*[a-zA-Z_]*)+$/,message:"根目录格式不正确",trigger:"blur"}]},customFieldTableDialogTitle:"自定义属性",customFieldTableDialogVisible:!1,customFieldTableData:[],editModeEnabled:!1,currentTemplateId:null}},created:function(){this.fetchData()},methods:{handleFilter:function(){this.fetchData()},handleResetQuery:function(){this.listParam={current:1,size:10},this.fetchData()},fetchData:function(){var t=this;this.listLoading=!0,Object(l["c"])(this.listParam).then((function(e){t.list=e.data.records,t.total=e.data.total,t.listLoading=!1}))},handleDetail:function(t){this.$router.push({name:"DetailTemplate",params:{id:t.id}})},handleCustom:function(t){var e=this;this.currentTemplateId=t.id,Object(l["a"])(t.id).then((function(t){e.customFieldTableData=t.data,e.customFieldTableDialogVisible=!0}))},addNewField:function(){this.editModeEnabled=!0,this.customFieldTableData.push({})},handleDeleteField:function(t){this.customFieldTableData.splice(this.customFieldTableData.findIndex((function(e){return e.key===t.key})),1)},saveFields:function(){var t=this,e={customField:JSON.stringify(this.customFieldTableData)};console.log(e),Object(l["j"])(e,this.currentTemplateId).then((function(){t.customFieldTableDialogVisible=!1,t.editModeEnabled=!1,Object(v["b"])(t)}))},handleEdit:function(t){this.saveOrUpdateFormTitile="编辑",this.updateId=t.id,this.saveOrUpdateForm=t,this.saveOrUpdateFormVisible=!0},handleCreate:function(){this.saveOrUpdateFormTitile="新增",this.updateId=null,this.saveOrUpdateForm={},this.saveOrUpdateFormVisible=!0},updateTemplate:function(){var t=this;this.saveOrUpdateLoading=!0,Object(l["i"])(this.saveOrUpdateForm,this.updateId).then((function(){t.resetForm(t.saveOrUpdateFormRef),t.saveOrUpdateFormVisible=!1,t.fetchData(),Object(v["b"])(t),t.saveOrUpdateLoading=!1})).catch((function(){t.saveOrUpdateLoading=!1}))},saveTemplate:function(){var t=this;this.saveOrUpdateLoading=!0,Object(l["f"])(this.saveOrUpdateForm).then((function(){t.resetForm(t.saveOrUpdateFormRef),t.saveOrUpdateFormVisible=!1,t.fetchData(),Object(v["b"])(t),t.saveOrUpdateLoading=!1})).catch((function(){t.saveOrUpdateLoading=!1}))},saveOrUpdateTemplate:function(){var t=this;this.$refs[this.saveOrUpdateFormRef].validate((function(e){e&&(null==t.updateId?t.saveTemplate():t.updateTemplate())}))},handleDelete:function(t){var e=this;Object(v["a"])(this,(function(){Object(l["d"])(t.id).then((function(){e.fetchData(),Object(v["b"])(e)}))}))},resetForm:function(t){this.$refs[t].resetFields()}}},U=w,x=Object(m["a"])(U,n,i,!1,null,null,null);e["default"]=x.exports},e9c4:function(t,e,a){var n=a("23e7"),i=a("d066"),l=a("d039"),o=i("JSON","stringify"),r=/[\uD800-\uDFFF]/g,s=/^[\uD800-\uDBFF]$/,u=/^[\uDC00-\uDFFF]$/,c=function(t,e,a){var n=a.charAt(e-1),i=a.charAt(e+1);return s.test(t)&&!u.test(i)||u.test(t)&&!s.test(n)?"\\u"+t.charCodeAt(0).toString(16):t},d=l((function(){return'"\\udf06\\ud834"'!==o("\udf06\ud834")||'"\\udead"'!==o("\udead")}));o&&n({target:"JSON",stat:!0,forced:d},{stringify:function(t,e,a){var n=o.apply(null,arguments);return"string"==typeof n?n.replace(r,c):n}})}}]);