const check = {
  //空校验
  isNullOrUndefined(value) {
    return value == null || typeof value == 'undefined' || value == '' || value.length == 0;
  },
  //校验是否超出最大长度 true未超出
  checkMaxLengrh(value, max) {
    return value.length <= max;
  },
  //校验是否低于最小长度 true未低于
  checkMinLength(value, min) {
    return value.length >= min;
  }
}

export default check
