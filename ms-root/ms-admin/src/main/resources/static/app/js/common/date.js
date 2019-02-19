// 对Date的扩展，将 Date 转化为指定格式的String   
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
// 例子：   
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
Date.prototype.format = function(fmt) {
	var o = {
		"M+": this.getMonth() + 1, //月份   
		"d+": this.getDate(), //日   
		"h+": this.getHours(), //小时   
		"m+": this.getMinutes(), //分   
		"s+": this.getSeconds(), //秒   
		"q+": Math.floor((this.getMonth() + 3) / 3), //季度   
		"S": this.getMilliseconds() //毫秒   
	};
	if(/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for(var k in o)
		if(new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
};

/**       
 * 对Date的扩展，将 Date 转化为指定格式的String       
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符       
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)       
 * eg:       
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423       
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04       
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04       
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04       
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18       
 */
Date.prototype.pattern = function(fmt) {
	var o = {
		"M+": this.getMonth() + 1, //月份           
		"d+": this.getDate(), //日           
		"h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时           
		"H+": this.getHours(), //小时           
		"m+": this.getMinutes(), //分           
		"s+": this.getSeconds(), //秒           
		"q+": Math.floor((this.getMonth() + 3) / 3), //季度           
		"S": this.getMilliseconds() //毫秒           
	};
	var week = {
		"0": "/u65e5",
		"1": "/u4e00",
		"2": "/u4e8c",
		"3": "/u4e09",
		"4": "/u56db",
		"5": "/u4e94",
		"6": "/u516d"
	};
	if(/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	if(/(E+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
	}
	for(var k in o) {
		if(new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
};

// 说明：两个时间相减
// 参数：JS的Date类型，或者 string 类型，格式为：yyyy-MM-dd HH:mm:ss
// 返回: date1-date2的秒数
Date.prototype.substractDate = function(date1, date2) {
	var type1 = typeof date1;
	var type2 = typeof date2;
	if(type1 == 'string') {
		date1 = new Date(date1);
	}
	if(type2 == 'string') {
		date2 = new Date(date2);
	}
	return(date1 - date2) / 1000;
};

//两个日期相差的月份
Date.prototype.getDiffMonths = function(date1, date2) {
	if(!date1 instanceof Date) {
		console.error('param date1 is not Date');
	}
	if(!date2 instanceof Date) {
		console.error('param date2 is not Date');
	}
	var months1 = date1.getFullYear() * 12 + date1.getMonth();
	var months2 = date2.getFullYear() * 12 + date2.getMonth();
	return months1 - months2;
};

// 说明：添加天数
// 参数：天数 比如40天
// 结果：比如日期：2016-06-13，加40天，结果为：2016-07-23
Date.prototype.addDays = function(days) {
	var date = new Date(this);
	date.setDate(date.getDate() + days);
	return date;
}