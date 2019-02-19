var Web_SupplierList = function(options) {
	this.init(options);
};
Web_SupplierList.prototype = {
	init: function(options) {
		var that = this;
		//设置初始参数
		that.setOptions(options);

		//初始化查询列表
		that.initQueryParam();

		//初始化Button的点击事件
		var oButtonInit = that.buttonInit();
		oButtonInit.Init();

		//初始化Table
		var supplierListTable = that.initSupplierListTable();
		//加载表格
		supplierListTable.init();

		//初始化模块
		this.supplierDetail = new Web_supplierDetail({
			supplierTableRefresh: function() {
				that.tableRefresh();
			}
		});
	},
	setOptions: function(options) {
		this.options = $.extend(this.options, options);
	},
	initQueryParam: function() {
		var that = this;

		$('#form_search_supplier input[type="text"]').val("");
		$('#form_search_supplier select').val("");
	},
	getQueryParams: function(params) {
		var sort = "create_time";
		if(params.sort == "createTime") {
			sort = "create_time";
		} else if(params.sort == "updateTime") {
			sort = "update_time";
		}

		return [{
			name: "limit",
			value: params.limit //页面大小
		}, {
			name: "start",
			value: params.offset //页码
		}, {
			name: "order",
			value: params.order //排序方式
		}, {
			name: "sort",
			value: sort //排序字段
		}, {
			name: "supplierIds",
			value: $("#se_supplierids").val()
		}, {
			name: "supplierName",
			value: $("#se_suppliername").val()
		}];
	},
	initSupplierListTable: function() {
		var that = this;
		var oTableInit = new Object();

		//初始化Table
		oTableInit.init = function() {
			$('#table_supplierlist').bootstrapTable({
				url: '/setting/supplier/getSupplierList', //请求后台的URL（*）
				method: 'get', //请求方式（*）
				toolbar: '#toolbar_supplierlist', //工具按钮用哪个容器
				striped: true, //是否显示行间隔色
				cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: true, //是否显示分页（*）
				queryParams: function(params) {
					return that.getQueryParams(params);
				}, //传递参数（*）
				sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
				pageNumber: 1, //初始化加载第一页，默认第一页
				pageSize: 10, //每页的记录行数（*）
				pageList: [10, 50, 100, 150], //可供选择的每页的行数（*）
				search: false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch: true,
				showColumns: true, //是否显示所有的列
				showRefresh: true, //是否显示刷新按钮
				minimumCountColumns: 2, //最少允许的列数
				clickToSelect: false, //是否启用点击选中行
				height: 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
				uniqueId: "ID", //每一行的唯一标识，一般为主键列
				showToggle: false, //是否显示详细视图和列表视图的切换按钮
				cardView: false, //是否显示详细视图
				detailView: false, //是否显示父子表
				destroy: true,
				silent: true,
				sortable: true, //是否启用排序
				order: "desc",
				sort: "createTime",
				uniqueId: "id", //每一行的唯一标识，一般为主键列
				buttonsAlign: "right", //按钮位置
				Icons: 'glyphicon-export',
				contentType: "supplierlication/x-www-form-urlencoded", //设置成form表单的形式，tomcat内部就会自动将requset payload中的数据部分解析放到request.getParameter()中，之后就可以直接通过@RequestParam映射参数获取
				columns: [{
					checkbox: true
				}, {
					field: 'id',
					title: '供应商ID'
				}, {
					field: 'supplierName',
					title: '供应商名称'
				}, {
					field: 'phone',
					title: '手机号码'
				}, {
					field: 'email',
					title: '邮箱'
				}, {
					field: 'telephone',
					title: '电话号码'
				}, {
					field: 'address',
					title: '地址'
				}, {
					field: 'remark',
					title: '备注',
					visible: false
				}, {
					field: 'createTime',
					title: '创建时间',
					sortable: true,
					formatter: function(value, row, index) {
						if(value != null) {
							return new Date(value).format("yyyy-MM-dd hh:mm:ss");
						} else {
							return "";
						}
					}
				}, {
					field: 'updateTime',
					title: '更新时间',
					sortable: true,
					formatter: function(value, row, index) {
						if(value != null) {
							return new Date(value).format("yyyy-MM-dd hh:mm:ss");
						} else {
							return "";
						}
					}
				}, {
					title: '操作',
					formatter: function(value, row, index) {
						return _.template($("#temp_supplier_action").html())({
							id: row.id,
							supplierName: row.supplierName,
							actions: [{
								color: "btn-primary",
								name: "编辑",
								iconstyle: "fa-edit",
								value: "action_edit_supplier"
							}]
						});
					}
				}],
				onLoadSuccess: function() {
					$("#btn_search_supplier").removeClass("disabled");
					that.tableSupplierFinish();
				},
				onColumnSwitch: function() {
					that.tableSupplierFinish();
				},
				onToggle: function() {
					that.tableSupplierFinish();
				}
			});
		};

		return oTableInit;
	},
	buttonInit: function() {
		var that = this;
		var oInit = new Object();

		//初始化页面上面的按钮事件
		oInit.Init = function() {
			// 搜索
			$('#btn_search_supplier').click(function() {
				if(!$(this).hasClass("disabled")) {
					$('#btn_search_supplier').addClass("disabled");
					$("#table_supplierlist").bootstrapTable('refreshOptions', {
						pageNumber: 1
					});
				}
			});

			// 添加
			$('#btn_add_supplier').off("click.ibcp").on("click.ibcp", function() {
				that.addSupplier();
			});
		};

		return oInit;
	},
	tableSupplierFinish: function() {
		var that = this;

		// 修改
		$('a[data-action="action_edit_supplier"]').click(function() {
			var supplierId = $(this).parent("span").data("id");
			that.editSupplier(supplierId);
		});
	},
	tableRefresh: function() {
		$("#table_supplierlist").bootstrapTable('refreshOptions', {
			pageNumber: 1
		});
	},
	addSupplier: function() {
		var that = this;

		this.supplierDetail.resetForm(function() {
			that.supplierDetail.setFormData({});
			that.supplierDetail.show();
		});
	},
	editSupplier: function(supplierId) {
		this.supplierDetail.loadForm(supplierId);
	}
};

var Web_supplierDetail = function(options) {
	this.init(options);
};
Web_supplierDetail.prototype = {
	init: function(options) {
		this.options = options;
		var that = this;

		//返回列表 取消
		$("#supplierSaveBack").click(function() {
			that.hide();
		});

		// 保存
		$("#btn_supplier_save").click(function() {
			that.saveSupplier();
		});
	},
	show: function() {
		$("#div_supplier_list").addClass("hide");
		$("#div_supplier_detail").removeClass("hide");
	},
	hide: function() {
		var that = this;
		that.options.supplierTableRefresh();
		$("#div_supplier_list").removeClass("hide");
		$("#div_supplier_detail").addClass("hide");
		$('#supplierSaveBackModal').modal('hide');
	},
	resetForm: function(callBack) {
		$("#form_supplier input").val("");
		$("#form_supplier select").val("");
		$("#form_supplier textarea").val("");
		$("#form_supplier input[type='checkbox']").removeAttr("checked");

		if($.isFunction(callBack)) {
			callBack();
		}
	},
	loadForm: function(id) {
		var that = this;
		$.ajax({
			url: "/setting/supplier/getSupplierDetail",
			type: "get",
			data: {
				id: id
			},
			dataType: "json",
			success: function(json) {
				if(json.rsCode == "A000000") {
					that.resetForm(function() {
						that.setFormData(json.data);
						that.show();
					});
				} else {
					$.gritter.add({
						title: "提示信息：",
						text: "获取详情失败：" + json.rsMsg,
						time: 10000
					});
				}
			}
		});
	},
	getFormData: function() {
		var that = this;
		var data = {};
		$("#form_supplier input").each(function(index) {
			data[this.name] = $(this).val();
		});
		$("#form_supplier select").each(function(index) {
			data[this.name] = $(this).val();
		});
		$("#form_supplier textarea").each(function(index) {
			data[this.name] = $(this).val();
		});

		return data;
	},
	setFormData: function(data) {
		var that = this;

		$.each(data, function(key, value) {
			$("#form_supplier input[name=" + key + "]").val(value);
			$("#form_supplier select[name=" + key + "]").val(value);
			$("#form_supplier textarea[name=" + key + "]").val(value);
		});
	},
	checkFormData: function(data) {
		var result = [];

		if(_.isEmpty(data.supplierName)) {
			result.push("请输入供应商名称！");
		}

		return result;
	},
	saveSupplier: function() {
		var that = this;
		var data = that.getFormData();
		var checkResult = that.checkFormData(data);
		if(checkResult.length > 0) {
			$.gritter.add({
				title: "提示信息：",
				text: checkResult.join("</br>"),
				time: 2000
			});
			return;
		}

		$("#btn_supplier_save").attr("disabled", true);
		$.ajax({
			url: "/setting/supplier/saveSupplier",
			type: "post",
			data: data,
			dataType: "json",
			success: function(json) {
				if(json.rsCode == "A000000") {
					$.gritter.add({
						title: "提示信息：",
						text: "保存供应商成功！",
						time: 2000
					});
					that.hide();
				} else {
					$.gritter.add({
						title: "提示信息：",
						text: "保存供应商失败：" + json.rsMsg,
						time: 10000
					});
				}
			}
		});
		$("#btn_supplier_save").attr("disabled", false);
	}
};