/*function displayInfo(arg){
	var test="";
	if(typeof arg.name=="string"){
		test+="Name:"+arg.name+"\n";
	}
	if(typeof arg.age=="number"){
		test+="Age:"+arg.age+"\n";
	}
	alert(test);
}
displayInfo({
	name:'woca',
	age:5
});
displayInfo({
	name:'woca',
});*/
function compare(value1,value2){
//	if(value1>value2){
//		return 1;
//	}else if(value1<value2){
//		return -1;
//	}else{
//		return 0;
//	}
	return value1-value2;
}
var arrTest1=[9,5,2,7,15,36];
//调用函数不加括号表示引入该函数的对象不会立即执行该函数，加括号就会执行该函数并获取返回值。
var newArr=arrTest1.sort(compare);
alert(newArr.join());