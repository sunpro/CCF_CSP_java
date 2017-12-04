int year;
int num;
int[12] daysOfMonth;
Boolean isLeap;
//判断是否是闰年
isLeap;
//给daysOfMonth赋值；
若是闰年 dayOfMonth[1] = 29;
否则 daysOfMonth[1] = 28;
其它都是固定的赋值
//计算输入时间的具体日期
int sum;
for(int i = 0; i < 12; i++){
	sum += daysOfMonth[i];
	if( num > sum) continue;
	else{
	month = i + 1;
	day = daysOfMonth[i] - (sum - daysOfMonth[i]); 
	}
}

