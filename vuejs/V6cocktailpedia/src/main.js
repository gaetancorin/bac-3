import MainMenu from "./components/MainMenu.js";
import router from "./router/index.js";

const options = {
  data() {
    return {
    };
  },
  components: {
    MainMenu,
  },
};

const app = Vue.createApp(options);

app.use(router);

app.mount("#app");
