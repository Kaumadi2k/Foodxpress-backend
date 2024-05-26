import axios from "axios";

const CATEGORY_API_URL = "http://localhost:9000/api/v1/category"

export const listCategory = ()=>{
  return axios.get(CATEGORY_API_URL);
}