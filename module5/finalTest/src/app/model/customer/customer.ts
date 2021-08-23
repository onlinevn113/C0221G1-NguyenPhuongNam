import {CustomerType} from './customer-type';

export interface Customer {
  id?: number;
  name?: string;
  birthday?: string;
  gender?: number;
  email?: string;
  customerType?: CustomerType;
  localDateTime?: string;
  stringDateTime?: string;
  timee?: string;
}

