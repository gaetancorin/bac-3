import App from "./app.js";

const options = {
  data(){
    return {
    }
  },
  components: {
    App,
  },
}

Vue.createApp(options).mount("#app");