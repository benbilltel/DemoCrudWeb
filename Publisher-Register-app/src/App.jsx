import { useEffect, useState } from "react";
import PublisherCrud from "./components/PublisherCrud";
import apiPublisher from "./api/AxiosConfig";
import "bootstrap/dist/css/bootstrap.CSS"

function App(){
  const [publishers,setPublishers] = useState([]);
  useEffect(()=>{
    (async()=>await load())();
  },[])
  async function load(){
    const result = await apiPublisher.get("/all");
    setPublishers(result.data);
  }
  return (<div className="container">
    <h1 className="text-center">List Of Publisher</h1>
    <PublisherCrud load={load} publishers={publishers}></PublisherCrud>
  </div>);
}
export default App