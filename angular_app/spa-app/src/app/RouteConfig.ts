import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { CareerComponent } from './career/career.component';
import { DeptComponent } from './dept/dept.component';
import { Routes } from '@angular/router';

export const routeArray: Routes[] = [{
    path: "",
    component: HomeComponent
}, {
    path: "home",
    component: HomeComponent
}, {
    path: "about",
    component: AboutComponent
}, {
    path: "career",
    component: CareerComponent
}, {
    path: "dept/:string",
    component: DeptComponent
}, {
    path: "dept",
    component: DeptComponent
}, {
    path: "**",
    component: NotFoundComponent
}];