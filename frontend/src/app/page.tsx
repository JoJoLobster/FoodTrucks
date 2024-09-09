"use client"
import styles from "./page.module.css";
import SearchArea from "@/components/SearchArea";
import MarkMap from "@/components/MarkMap";
import { useState } from "react";
import search from "@/api/FoodTruckFetcher";
import FrontResp from "@/types/FrontResp";



export default function Home() {

  let [data, setData] = useState([]);
  let [errorTip, setErrorTip] = useState("");

  let searchByCityAndFood = function(city:string, foodName:string) {
    console.log("searching city: " + city, "foodName:" + foodName);
    let params = {"city": city, "foodName": foodName};
  
    search(params, (res:FrontResp) => { 
      if(res.ok) {
        setErrorTip("");
        console.log("api resp: ", res.data);
        setData(res.data);
      } else {
        setErrorTip("Error: failed to fetch data");
      }
    });
}

  return (
    <div className={styles.page}>
      <div className={styles.main}>
        <SearchArea search={searchByCityAndFood}/>
        <div style={{"display": errorTip==""?"none":""}}>{errorTip}</div>
        <MarkMap data={data}/>
      </div>
    </div>
  );
}
