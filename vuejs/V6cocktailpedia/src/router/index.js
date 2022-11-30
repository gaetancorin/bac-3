import App from "../components/App.js";
import CreditView from "../views/CreditView.js";
import NotFound from "../views/NotFound.js";

const routes = [
  { path: "/", component: App },
  { path: "/credit", component: CreditView },
  { path: "/:pathMatch(.*)*", component: NotFound },
];

const router = VueRouter.createRouter({
  history: VueRouter.createWebHistory(),
  routes,
});

export default router;
