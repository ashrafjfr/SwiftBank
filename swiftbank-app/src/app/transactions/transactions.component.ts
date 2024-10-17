import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

interface Transaction {
  accountNumber: string;
  amount: number;
  date: string;
}

@Component({
  selector: 'app-transactions',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './transactions.component.html',
  styleUrl: './transactions.component.css'
})
export class TransactionsComponent implements OnInit {
  transactions: Transaction[] = [
    { accountNumber: '811-75253-860', amount: -21.55, date: '2024-09-18' },
    { accountNumber: '675-16561-252', amount: -497.26, date: '2024-09-24' },
    { accountNumber: '407-12052-554', amount: -373.16, date: '2024-10-09' },
    { accountNumber: '299-87820-110', amount: -176.9, date: '2024-10-01' },
    { accountNumber: '928-16156-989', amount: -262.27, date: '2024-09-19' },
    { accountNumber: '500-76873-229', amount: -52.23, date: '2024-10-12' },
    { accountNumber: '426-33571-201', amount: -345.18, date: '2024-09-22' },
    { accountNumber: '546-26994-860', amount: -484.42, date: '2024-09-26' },
    { accountNumber: '830-47171-864', amount: -220.33, date: '2024-09-21' },
    { accountNumber: '645-97955-295', amount: -97.44, date: '2024-09-21' },
    { accountNumber: '179-60928-715', amount: -104.63, date: '2024-09-30' },
    { accountNumber: '560-13208-996', amount: -299.48, date: '2024-10-14' },
    { accountNumber: '100-77674-338', amount: -177.77, date: '2024-09-28' },
    { accountNumber: '404-74938-454', amount: -370.35, date: '2024-10-06' },
    { accountNumber: '550-22156-823', amount: -278.43, date: '2024-10-05' },
    { accountNumber: '108-50485-965', amount: -253.83, date: '2024-09-27' },
    { accountNumber: '543-57761-489', amount: -112.95, date: '2024-10-14' },
    { accountNumber: '890-34687-274', amount: -486.46, date: '2024-09-21' },
    { accountNumber: '210-50843-545', amount: -359.31, date: '2024-10-14' },
    { accountNumber: '180-72574-466', amount: -417.71, date: '2024-10-16' }
  ];

  ngOnInit() {}
}
