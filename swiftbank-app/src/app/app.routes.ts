import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { TransferComponent } from './transfer/transfer.component';
import { TransactionsComponent } from './transactions/transactions.component';

export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegistrationComponent },
    { path: 'home', component: HomeComponent},
    { path: 'transactions', component: TransactionsComponent},
    { path: 'transfer', component: TransferComponent },
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: '**', redirectTo: '/login' }
];
