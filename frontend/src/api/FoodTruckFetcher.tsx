import FoodTruck from "@/types/FoodTruck";
import FrontResp from "@/types/FrontResp";

const API_HOST_PREFIX = 'http://localhost:8080/api/';

export default async function search(params?:object, callback?:Function) {
    let url = API_HOST_PREFIX + `trucks`
    console.log("data to requet:", params);
    fetch(url,
        { 
            method: 'POST',
            mode: "cors",
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
                'Accept': 'application/json',

            },
            body: JSON.stringify(params)
        })
    .then(response => response.json())
    .then(data => {
        console.log("api resp", data);
        if(callback)  {
            callback(data);
        }
    })
    .catch(error => {
        console.error(error);
        if(callback) callback({ok:false, err: error});
    });
}