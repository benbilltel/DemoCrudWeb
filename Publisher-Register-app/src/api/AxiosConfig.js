import axios from "axios";
const createAxiosInstance = (baseURL) =>{
    return axios.create({
        baseURL:baseURL
    });
};
const apiPublisher = createAxiosInstance("http://localhost:8080/publisher");
export default apiPublisher;