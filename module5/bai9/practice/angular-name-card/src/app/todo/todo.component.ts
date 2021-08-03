import {Component, OnInit} from '@angular/core';
import {Todo} from '../todo';

import {TodoService} from '../todo.service';
import Swal from 'sweetalert2';


// @ts-ignore
@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  name = '';
  todo: Todo;

  constructor(private s: TodoService) {
  }

  ngOnInit() {
    this.showList();
  }

  showList() {
    this.s.getAll().subscribe(t => {
      this.todos = t;
    });
  }

  create(a) {
    Swal.fire({
      text: 'Create new Todo' +
        '',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, create it!'
    }).then((result) => {
      console.log(this.name);
      if (result.isConfirmed) {
        console.log(a)
        this.todo.name = a;
        this.s.save(this.todo).subscribe();
        Swal.fire(
          'created!',
          '',
          'success'
        );
      }
    });
  }

  update(id: number) {
    Swal.fire({
      text: 'edit new Todo',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: ''
    }).then((result) => {
      if (result.isConfirmed) {
        this.s.findById(id).subscribe(c => {
          this.s.update(id, c).subscribe();
        });
        Swal.fire(
          'Updated!',
          '',
          'success'
        );
      }
    });
  }

  delete(id: number) {
    Swal.fire({
      title: 'Are you sure?',
      text: 'You won\'t be able to revert this!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.s.delete(id).subscribe();
        Swal.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        );
      }
    });
  }

  chang(value) {
    this.name = value.value;
  }
}
