export class ValidateMsg {
  constructor() { }

  msgArr() {
  return  {
    customer_code: [
      {type: 'required', msg: 'Please Input'},
      {type: 'pattern', msg: 'Please Input invalid'},
    ],
    customerType: [
      {type: 'required', msg: 'Please choice'}
    ],
    gender: [
      {type: 'required', msg: 'Please choice'}

    ],
    name: [
      {type: 'required', msg: 'Please Input'},
      {type: 'minlength', msg: 'Please Input >5 letter'},
      {type: 'pattern', msg: 'Please Input invalid'}
    ],
    birthday: [
      {type: 'required', msg: 'Please Input'}
    ],
    idCard: [
      {type: 'required', msg: 'Please Input'},
      {type: 'pattern', msg: 'Please Input invalid'},
    ],
    phonee: [
      {type: 'required', msg: 'Please Input'},
      {type: 'pattern', msg: 'Please Input invalid'},
    ],
    email: [
      {type: 'required', msg: 'Please Input'},
      {type: 'email', msg: 'Please Input invalid'},
    ],
    addresss: [
      {type: 'required', msg: 'Please Input'},
      {type: 'minlength', msg: 'Please Input >5 letter'},
    ],
  };
  }
}
